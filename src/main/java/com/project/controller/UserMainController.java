package com.project.controller;


import com.project.pojo.News;
import com.project.service.impl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserMainController {
    @Autowired
    private NewsServiceImpl newsService;

    @RequestMapping("/main")
    public String selectnews(Model model){

        List<News> newsList = newsService.selectNewsAll();
        //PageInfo封装分页信息
        model.addAttribute("newsList",newsList);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl","userInfoActive");
        model.addAttribute("activeUrl2","userInfoActive");


        return "user/main";
    }

}
