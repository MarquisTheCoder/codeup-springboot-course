package com.codeup.spring_blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GettingDataController {

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String joinGet(Model model){
        return "getting-data-test";
    }
    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String joinPost(@RequestParam(name = "cohort") String cohort, Model model){
        model.addAttribute("cohort", "welcome to your new cohort " + cohort + "!");
        return "showing-data-test";
    }
}
