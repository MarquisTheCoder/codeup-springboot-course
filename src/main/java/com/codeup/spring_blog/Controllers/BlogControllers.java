package com.codeup.spring_blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlogControllers {


    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name){
        return String.format("Hello %s from spring", name);
    }

}


