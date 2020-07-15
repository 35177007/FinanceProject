package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.ChangeMoney;
import com.project.pojo.FlowOfFunds;
import com.project.pojo.UserChangeInfo;
import com.project.service.impl.UserChangeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Controller
@RequestMapping("/user")
public class UserChangeController {
    @Autowired
    public UserChangeServiceImpl userChangeService;

    @RequestMapping("/finance/toChangeMoney")
    public String selectUserChangeAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model){

        PageHelper.startPage(pageNum,pageSize);
        List<ChangeMoney> changeMoneyList = userChangeService.selectUserChangeAll();
        //PageInfo封装分页信息
        PageInfo<ChangeMoney> finacnePageInfo = new PageInfo<ChangeMoney>(changeMoneyList);

        model.addAttribute("finacnePageInfo",finacnePageInfo);
        model.addAttribute("changeMoneyList",changeMoneyList);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl","userInfoActive");
        model.addAttribute("activeUrl2","userInfoActive");


        return "user/finance/changemoney";

    }

    @RequestMapping("/getUserChangeById/{id}")
    @ResponseBody
    public Msg selectUserChangeById(@PathVariable("id") Integer id) {
        ChangeMoney changeMoney = userChangeService.selectUserChangeById(id);
        return Msg.success().add("changeMoney",changeMoney);
    }

    @RequestMapping("/buyChangeMoney")
    @ResponseBody
    public Msg insertbuyChangeMoney(@RequestParam("changeMoneyId") Integer changeMoneyId,@RequestParam("userId") Integer userId) {
        Date utilDate  =new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        ChangeMoney changeMoney = userChangeService.selectUserChangeById(changeMoneyId);
        BigDecimal money = changeMoney.getInvesMoney();
        String name = changeMoney.getName();
        String desc = "无";
        FlowOfFunds flowOfFunds = new FlowOfFunds(null,userId,money,1,name,sqlDate,desc);
        System.out.println(flowOfFunds);
        int i = userChangeService.insertFlowOfFund(flowOfFunds);
        BigDecimal averYield = changeMoney.getAnnualIncome();
        BigDecimal profit = changeMoney.getPeiIncome();
        UserChangeInfo userChangeInfo = new UserChangeInfo(null,userId,changeMoneyId,sqlDate,averYield,profit,1);
        System.out.println(userChangeInfo);
        int j = userChangeService.insertUserChange(userChangeInfo);
        if(i == 1&&j == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }

    }
}
