package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.BankCard;
import com.project.pojo.Reputation;
import com.project.pojo.User;
import com.project.service.impl.BankCardServiceImpl;
import com.project.service.impl.ReputationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/userinfo")
public class ReputationController {
    @Autowired
    private ReputationServiceImpl reputationService;

    @RequestMapping("/toReputation")
    public String selectReputationAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model){

        PageHelper.startPage(pageNum,pageSize);
        List<Reputation> userList = reputationService.selectReputationAll();
        //PageInfo封装分页信息
        PageInfo<Reputation> userPageInfo = new PageInfo<Reputation>(userList);

        model.addAttribute("userPageInfo",userPageInfo);
        model.addAttribute("userList",userList);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","userInfoActive");
        model.addAttribute("activeUrl2","reputationActive");


        return "admin/userinfo/reputation";

    }
    @RequestMapping("/user/getReputationById/{id}")
    @ResponseBody
    public Msg getReputationInfoById(@PathVariable("id") Integer id){
        Reputation reputation = reputationService.selectReputationById(id);
        return Msg.success().add("user",reputation);
    }

    @RequestMapping("/user/updateReputationProfile/{id}")
    @ResponseBody
    public Msg updateReputationProfile(Reputation reputation){
        int i = reputationService.updateReputation(reputation);
        if (i == 1){
            return Msg.success();
        }
        else{
            return Msg.fail();
        }
    }
}
