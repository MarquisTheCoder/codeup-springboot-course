package com.codeup.spring_blog.Controllers;

import com.codeup.spring_blog.Entities.Post;
import com.codeup.spring_blog.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {


    @Autowired
    private PostRepository postRepository;

    //mapping to the post pages get request so it returns the post creation page
    //on get
    @GetMapping("/post")
    public String getPosts(Model model){
        model.addAttribute("post_title", postRepository.findAll());
        return "post/create";
    }

    //telling the controller that on post requests the user
    //data will be submitted to the controller and outputted through the html
    //model page
    @PostMapping("/post")
    public String createNewPost(
            @RequestParam("post_title") String post_title,
            @RequestParam("post_content") String post_content,
            @RequestParam("post_description") String post_description){

            Post post = new Post();

            post.setTitle(post_title);
            post.setDescription(post_description);
            post.setContent(post_content);

            postRepository.saveAndFlush((Post) post);
            return "redirect:/post";
    }
}
