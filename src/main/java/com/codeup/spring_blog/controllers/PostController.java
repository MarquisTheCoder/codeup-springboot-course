package com.codeup.spring_blog.controllers;

import com.codeup.spring_blog.models.Post;
import com.codeup.spring_blog.models.Users;
import com.codeup.spring_blog.repositories.PostRepository;
import com.codeup.spring_blog.repositories.UsersRepository;
import com.codeup.spring_blog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {



    private PostRepository postRepository;
    private UsersRepository usersRepository;
    private EmailService emailService;

    //automatically injecting need DAO dependencies into the
    //PostController class to access the database
    public PostController(PostRepository postRepository,
                          UsersRepository usersRepository,
                          EmailService emailService){
        this.emailService = emailService;
        this.postRepository = postRepository;
        this.usersRepository = usersRepository;

    }
    //mapping to the post pages get
    // request, so it returns the post
    // creation page on get
    @GetMapping("/post")
    public String getPosts(Model model){
        model.addAttribute("all_post", postRepository.findAll());
        return "post/create";
    }
    @PostMapping("/post")
    public String postPosts(){
        return "redirect:/post";
    }

    @GetMapping("/post/create")
    public String showCreateNewPost(){
        return "post/create";
    }

    //telling the controller that on post requests the user
    //data will be submitted to the controller and outputted through the html
    //model page
    @PostMapping("/post/create")
    public String createNewPost(
            @RequestParam("post_title") String post_title,
            @RequestParam("post_content") String post_content,
            @RequestParam("post_description") String post_description){

        Users user = (Users) usersRepository.getReferenceById(1L);
        //creating a Post
        // object to be saved
        // to the server
        new Post();
        Post post = Post.builder()
                    .title(post_title)
                    .description(post_description)
                    .content(post_content)
                    .user((Users)user)
                    .build();

            String email = post.getUser().getEmail();
            postRepository.saveAndFlush((Post) post);
            return "redirect:/post";
    }

    //path to show edit page for page with an id of ${id}
    @GetMapping("/post/{id}/edit")
    public String editPostShow(@PathVariable int id, Model model){
        //checking to see if the user exist by id and if it doesn't it returns
        //them to the post page where all post are displayed to the user.
        if(postRepository.existsById((long) id)){
            Post post = postRepository.getReferenceById((long) id);
            model.addAttribute("id", id);
            model.addAttribute("post", post);
            return "post/edit";
        }else{
           return "redirect:/post";
        }

    }

    //on post to the edit page given a user id the repository sends the user
    //data to the repository and then alerts the user with that email
    //the post was edited just in case someone other than the user edited the post
    @PostMapping("/post/{id}/edit")
    public String editPost(@ModelAttribute Post post,@PathVariable int id){
        postRepository.saveAndFlush(post);
        emailService.prepareAndSend(
                post,
                "Alert Post Edit",
                "testing to see if the getMail function is null");
        return "redirect:/post";
    }
}
