package com.codeup.spring_blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TestController {

    @GetMapping("/testing/{function}")
    public String testing(@PathVariable String function, Model model){
        model.addAttribute("function", function);
        return "function";
    }
}
