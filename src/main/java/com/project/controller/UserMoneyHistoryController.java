package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.pojo.User;
import com.project.pojo.UserMoneyHistory;
import com.project.service.impl.UserMoneyHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserMoneyHistoryController {
    @Autowired
    private UserMoneyHistoryServiceImpl userMoneyHistoryService;

    @RequestMapping("/user/tools/toRecord")
    public String selectMoneyHistory(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model, HttpServletRequest request){


        //引入分页信息
        //首先引入PageHelper插件
        PageHelper.startPage(pageNum,pageSize);
        User user = (User)request.getSession().getAttribute("user");
        Integer id = user.getId();

        //PageInfo封装分页信息
        List<UserMoneyHistory> userMoneyHistories = userMoneyHistoryService.selectUserMoneyHistory(id);
        PageInfo<UserMoneyHistory> pageInfo = new PageInfo<UserMoneyHistory>(userMoneyHistories);
        model.addAttribute("flowOfFundsPageInfo",pageInfo);
        model.addAttribute("flowOfFundsList",userMoneyHistories);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","userInfoActive");
        model.addAttribute("activeUrl2","userInfoActive");


        return "user/tools/record";
    }
}
