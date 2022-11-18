package com.codeup.spring_blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollDice {
    int randomNumber = (int)(Math.random() * 6) + 1;

    @GetMapping("/roll-dice/{n}")
    @ResponseBody
    public String rollDice(@PathVariable int n){

        if(n == randomNumber){
            return "Correct! You got the right number!";
        }else{
            return "Wrong! dummy! >:(";
        }
    }


}
