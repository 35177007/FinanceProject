package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.PayMoney;
import com.project.pojo.FlowOfFunds;
import com.project.pojo.PayMoney;
import com.project.pojo.UserPayInfo;
import com.project.service.impl.UserPayServiceImpl;
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
public class UserPayController {

    @Autowired
    public UserPayServiceImpl userPayService;

    @RequestMapping("/finance/toPayMoney")
    public String selectUserPayAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model){

        PageHelper.startPage(pageNum,pageSize);
        List<PayMoney> payMoneyList = userPayService.selectUserPayAll();
        //PageInfo封装分页信息
        PageInfo<PayMoney> finacnePageInfo = new PageInfo<PayMoney>(payMoneyList);

        model.addAttribute("finacnePageInfo",finacnePageInfo);
        model.addAttribute("payMoneyList",payMoneyList);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl","userInfoActive");
        model.addAttribute("activeUrl2","userInfoActive");


        return "user/finance/paymoney";

    }

    @RequestMapping("/getUserPayById/{id}")
    @ResponseBody
    public Msg selectUserPayById(@PathVariable("id") Integer id) {
        PayMoney payMoney = userPayService.selectUserPayById(id);
        return Msg.success().add("payMoney",payMoney);
    }

    @RequestMapping("/buyPayMoney")
    @ResponseBody
    public Msg insertbuyPayMoney(@RequestParam("payMoneyId") Integer payMoneyId,@RequestParam("userId") Integer userId) {
        Date utilDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        PayMoney payMoney = userPayService.selectUserPayById(payMoneyId);
        BigDecimal money = payMoney.getMonthMoney();
        String name = "工资理财";
        String status;
        int desc = payMoney.getType();
        if(desc == 2) {
            status = "期货";
        }else {
            status = "国债";
        }
        FlowOfFunds flowOfFunds = new FlowOfFunds(null,userId,money,1,name,sqlDate,status);
        System.out.println(flowOfFunds);
        int i = userPayService.insertFlowOfFund(flowOfFunds);
        BigDecimal averYield = new BigDecimal(0.03123);
        BigDecimal profit = money.multiply(averYield);
        UserPayInfo userPayInfo = new UserPayInfo(null,userId,payMoneyId,sqlDate,averYield,profit,1);
        System.out.println(userPayInfo);
        int j = userPayService.insertUserPay(userPayInfo);
        if(i == 1&&j == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }

    }

}
