package org.masa.ayanoter.Controllers;


import org.masa.ayanoter.Services.IAuthorizationService;
import org.masa.ayanoter.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {

   public List<Post> posts = new ArrayList<>();

    public HomeController() {
    }

    @RequestMapping("/home/news")
    public String getNews(Model model) throws Exception {
        posts.add(new Post("User1","Blah-Blah"));
        posts.add(new Post("User2","Qu-Qu"));
        model.addAttribute("posts",posts);
        return "home/news";
    }

    @RequestMapping("/home/settings")
    public String getSettings() throws Exception {
        return "home/settings";
    }

    @RequestMapping("/home/newpost")
    public String getNewPost(@RequestParam("newtext") String text) throws Exception {
        posts.add(new Post("UserNew",text));
        return "redirect:/home/news";
    }
}
