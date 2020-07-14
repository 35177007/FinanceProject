package com.project.controller;

import com.project.pojo.Bank;
import com.project.service.impl.UserBankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user/finance")
public class UserBankController {

    @Autowired
    private UserBankServiceImpl userBankService;

    @RequestMapping("/toBank")
    public String selectBankAll(Model model){

        List<Bank> bankList = userBankService.selectBankAll();
        //PageInfo封装分页信息
        model.addAttribute("bankList",bankList);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl","userInfoActive");
        model.addAttribute("activeUrl2","userInfoActive");

        return "user/finance/bank";
    }
}
