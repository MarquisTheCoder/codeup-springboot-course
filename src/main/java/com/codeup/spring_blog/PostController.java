package com.codeup.spring_blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/post")
    @ResponseBody
    public String getPosts(){
        return "this will return all post";
    }

    @GetMapping("/post/{id}")
    @ResponseBody
    public String getSpecificPost(){
        return "This returns individual post";
    }

    @GetMapping("/post/{create}")
    @ResponseBody
    public String getPostCreationScreen(){
        return "The page for creating post";
    }

    @PostMapping("/post/{create}")
    @ResponseBody
    public String createNewPost(){
        return "creating a post";
    }
}
