package com.codeup.spring_blog.Controllers;

import com.codeup.spring_blog.Entities.Post;
import com.codeup.spring_blog.Entities.Users;
import com.codeup.spring_blog.Repositories.PostRepository;
import com.codeup.spring_blog.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {



    private PostRepository postRepository;
    private UsersRepository usersRepository;


    //automatically injecting need DAO dependencies into the
    //PostController class to access the database
    public PostController(PostRepository postRepository,
                          UsersRepository usersRepository){
        this.postRepository = postRepository;
        this.usersRepository = usersRepository;

    }

    //mapping to the post pages get request so it returns the post creation page
    //on get
    @GetMapping("/post")
    public String getPosts(Model model){
        model.addAttribute("post_title", postRepository.findAll());
        return "post/create";
    }

    @GetMapping("/post/{id}/edit")
    public String editPostShow(@PathVariable(name  = "id") Long id,
                           Model model){
        model.addAttribute("post", new Post());
        return "post/edit";
    }
    @PostMapping("/post/{id}/edit")
    public String editPost(@PathVariable(name = "id") Long id, @ModelAttribute Post post, Model model){
        model.addAttribute("id", id);
        postRepository.saveAndFlush(
                postRepository.getById(id).builder()
                .title(post.getTitle())
                .description(post.getDescription())
                .content(post.getContent()).build());
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
            Users user = (Users) usersRepository.getById(1L);

            Post post = new Post().builder()
                            .title(post_title)
                                    .description(post_description)
                                            .content(post_content)
                                                    .user((Users)user)
                                                            .build();

            String email = post.getUser().getEmail();

            postRepository.saveAndFlush((Post) post);
            return "redirect:/post";
    }
}
