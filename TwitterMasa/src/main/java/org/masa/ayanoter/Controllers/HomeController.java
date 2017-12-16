package org.masa.ayanoter.Controllers;


import org.masa.ayanoter.models.JsonResponse;
import org.masa.ayanoter.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {

    public List<Post> posts = new ArrayList<>();

    public HomeController() {
    }

    @RequestMapping("/home/news")
    public String getNews(Model model) throws Exception {
//        posts.add(new Post("User1","Blah-Blah"));
//        posts.add(new Post("User2","Qu-Qu"));
//        for (int i = 0; i < 20; i++) {
//            posts.add(new Post("User" + i, "text" + i));
//            Thread.sleep(1000);
//        }

        model.addAttribute("posts", posts);
        return "home/news";
    }

    @RequestMapping("/home/settings")
    public String getSettings() throws Exception {
        return "home/settings";
    }

    @RequestMapping("/home/newpost")
    public String getNewPost(@RequestParam("newtext") String text) throws Exception {
        posts.add(0,new Post("UserNew", text));
        return "redirect:/home/news";
    }

    @RequestMapping(value= "/home/plusl", method = RequestMethod.POST,  headers = {"Content-type=application/json"})
    @ResponseBody
    public JsonResponse getPlusLike(@RequestBody String currentPost) throws Exception {
        String replaced = currentPost.replace('%', '@');
        replaced = replaced.substring(replaced.indexOf('=')+1,replaced.length());
        Post p = null;
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId()==Integer.parseInt(replaced)) {
                p=posts.get(i);
                p.increaseLikeCount();
            }
        }
        return new JsonResponse("OK",String.valueOf(p.getId()),p);
    }

    @RequestMapping(value= "/home/plusr", method = RequestMethod.POST,  headers = {"Content-type=application/json"})
    @ResponseBody
    public JsonResponse getPlusRepost(@RequestBody String currentPost) throws Exception {
        String replaced = currentPost.replace('%', '@');
        replaced = replaced.substring(replaced.indexOf('=')+1,replaced.length());
        Post p = null;
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId()==Integer.parseInt(replaced)) {
                p=posts.get(i);
                p.increaseRepostCount();
            }
        }
        return new JsonResponse("OK",String.valueOf(p.getId()),p);
    }


    @RequestMapping("/home/newcomment")
    public String newComment(@RequestParam("comtext") String comtext,@RequestParam("post") String post) throws Exception {
        String replaced = post.replace('%', '@');
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).toString().equals(replaced)) {
                posts.get(i).addComment("NewUser",comtext);
            }
        }
        return "redirect:/home/news";
    }
}
