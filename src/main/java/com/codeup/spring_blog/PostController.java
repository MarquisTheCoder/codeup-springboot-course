package com.codeup.spring_blog;

import com.codeup.spring_blog.Repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/post")
    public String getPosts(@RequestParam(name = "post_title") String post_title, Model model){
        model.addAttribute("ads", postDao.findAll());
        model.addAttribute("post_title", post_title);
        return "post/create";
    }

    @PostMapping("/post")
    public String createNewPost(
            @RequestParam(name = "post_title") String post_title,
            @RequestParam(name = "post_content") String post_content,
            Model model){

            model.addAttribute("post_title", post_title);
            model.addAttribute("post_content", post_content);
            return "post/post";
    }
}
