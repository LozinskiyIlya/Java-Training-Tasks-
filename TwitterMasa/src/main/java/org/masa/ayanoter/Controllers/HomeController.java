package org.masa.ayanoter.Controllers;


import org.masa.ayanoter.Repositories.PostRepository;
import org.masa.ayanoter.Repositories.SubscriptionRepository;
import org.masa.ayanoter.Repositories.UserRepository;
import org.masa.ayanoter.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


@Controller
public class HomeController {

    private PostRepository postRepository;
    private UserRepository userRepository;
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    public HomeController(PostRepository postRepository, UserRepository userRepository, SubscriptionRepository subscriptionRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    @RequestMapping("/home/news")
    public String getNews(Model model) throws Exception {
        Iterable<Post> i = postRepository.findAll();
        Iterator<Post> iterator = i.iterator();
        LinkedList<Post> posts = new LinkedList<>();
        while(iterator.hasNext()){
            posts.addFirst(iterator.next());
        }

        model.addAttribute("posts", posts);

        List<Subscription> subscriptions = subscriptionRepository.
                findByFromUser(userRepository.findByLogin("Vasya"));

        model.addAttribute("subs",subscriptions);

        return "home/news";
    }

    @RequestMapping(value = "/home/image", method = RequestMethod.GET)
    public void showImage(@RequestParam("id") Integer itemId, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException, SQLException {
        System.out.println(itemId);

        User user= userRepository.findOne(itemId);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(user.image.getBytes(1, Math.toIntExact(user.image.length())));


        response.getOutputStream().close();
    }

    @RequestMapping("/home/settings")
    public String getSettings() throws Exception {
        return "home/settings";
    }

    @RequestMapping("/home/profile")
    public String getProfile() throws Exception {
        return "home/profile";
    }

    @RequestMapping("/home/newpost")
    @Transactional
    public String getNewPost(@RequestParam("newtext") String text) throws Exception {
        Post post = new Post();
        post.setUser(userRepository.findByLogin("Vasya"));
        post.setL_count(0);
        post.setR_count(0);
        post.setText(text);
        postRepository.save(post);
        return "redirect:/home/news";
    }

    @RequestMapping(value= "/home/plusl", method = RequestMethod.POST,  headers = {"Content-type=application/json"})
    @ResponseBody
    public JsonResponseLikeRepost getPlusLike(@RequestBody String currentPost) throws Exception {

        String replaced = currentPost.replace('%', '@');
        replaced = replaced.substring(replaced.indexOf('=')+1,replaced.length());
        Post p = postRepository.findOne(Integer.parseInt(replaced));
        p.l_count++;
        postRepository.save(p);
        return new JsonResponseLikeRepost("OK",String.valueOf(p.getId()),p);
    }

    @RequestMapping(value= "/home/plusr", method = RequestMethod.POST,  headers = {"Content-type=application/json"})
    @ResponseBody
    public JsonResponseLikeRepost getPlusRepost(@RequestBody String currentPost) throws Exception {
        String replaced = currentPost.replace('%', '@');
        replaced = replaced.substring(replaced.indexOf('=')+1,replaced.length());
        Post p = postRepository.findOne(Integer.parseInt(replaced));
        p.r_count++;
        postRepository.save(p);
        return new JsonResponseLikeRepost("OK",String.valueOf(p.getId()),p);
    }

/*
  @RequestMapping(value= "/home/newcomment", method = RequestMethod.POST,  headers = {"Content-type=application/json"})
    @ResponseBody
    public JsonResponseComment newComment(@RequestBody MultiValueMap<String, String> map) throws Exception {

        String currentPost = map.toString();
        System.out.println("!!!!!" + currentPost);
        String postId = map.get("post").get(0);
        Comment c = null;
        for (int i = 0; i < posts.size(); i++) {
            System.out.println(posts.get(0).toString());
            if (posts.get(i).toString().equals(postId)) {
                posts.get(i).addComment("NewUser",currentPost);
                c=posts.get(i).comments.get(0);
                System.out.println(c.text);
            }
        }
        return new JsonResponseComment("OK","",c);
    }*/
}
