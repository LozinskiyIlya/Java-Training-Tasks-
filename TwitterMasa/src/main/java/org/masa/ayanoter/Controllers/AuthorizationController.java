package org.masa.ayanoter.Controllers;


import org.masa.ayanoter.Services.IAuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthorizationController {

    private IAuthorizationService authorizationService;

    public AuthorizationController(IAuthorizationService authorizationService) {

        this.authorizationService = authorizationService;

    }

    @RequestMapping(path = "auth/login", method = RequestMethod.GET)
    public String getLogin() {
        return "auth/login";
    }

    @RequestMapping(path = "auth/login", method = RequestMethod.POST)
    public String postLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password, Model model, HttpServletResponse response) throws Exception {
        if (!authorizationService.isValid(username, password)) {
            throw new Exception("User is not valid");
        }

        int secret = authorizationService.getSecret(username, password);

        Cookie cookie = new Cookie("secret", String.valueOf(secret));
        cookie.setPath("/");
        response.addCookie(cookie);

        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("secret", secret);

        return "auth/successful";
    }
}
