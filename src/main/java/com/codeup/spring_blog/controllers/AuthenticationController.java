package com.codeup.spring_blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
     @GetMapping("/login")
    public String getRedirectLogin(){
        return "users/login";
    }

}
