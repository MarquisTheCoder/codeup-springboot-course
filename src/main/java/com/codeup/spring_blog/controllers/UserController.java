package com.codeup.spring_blog.controllers;

import com.codeup.spring_blog.models.Users;
import com.codeup.spring_blog.repositories.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UsersRepository usersRepository,
                          PasswordEncoder passwordEncoder){
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/users/sign-up")
    public String getSignUpPage(Model model){
        model.addAttribute("users", new Users());
        return "users/sign-up";
    }

    @PostMapping("/users/sign-up")
    public String postSignUpPage(@ModelAttribute Users users){
        String hash = passwordEncoder.encode(users.getPassword());
        users.setPassword(hash);
        usersRepository.save(users);
        return "redirect:/login";
    }

    @GetMapping("/sign-up")
    public String postSignUpRedirect(){
        return "redirect:/users/sign-up";
    }
}
