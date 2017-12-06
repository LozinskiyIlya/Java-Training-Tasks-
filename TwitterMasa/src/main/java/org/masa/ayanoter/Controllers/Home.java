package org.masa.ayanoter.Controllers;


import org.masa.ayanoter.Services.IAuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Home {

    public Home() {
    }

    @RequestMapping("/home/news")
    public String getNews() throws Exception {
        return "home/news";
    }
}
