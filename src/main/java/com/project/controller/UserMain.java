package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class UserMain {

        @RequestMapping("user/main")
        public String userHome(Model model){
            model.addAttribute("activeUrl","indexActive");
            model.addAttribute("activeUrl","userInfoActive");
            model.addAttribute("activeUrl2","userInfoActive");
            model.addAttribute("username","username");
            return "user/main";


    }
}
