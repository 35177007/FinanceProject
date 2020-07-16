package com.project.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.PayMoney;
import com.project.service.PayMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class PayMoneyController {
    @Autowired
    private PayMoneyService payMoneyService;

    @RequestMapping("/finance/toPayMoney")
    public String selectPayMoney(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model){

        PageHelper.startPage(pageNum,pageSize);
        List<PayMoney> payMoneyList = payMoneyService.selectPayMoneyAll();
        //PageInfo封装分页信息
        PageInfo<PayMoney> finacnePageInfo = new PageInfo<PayMoney>(payMoneyList);

        model.addAttribute("finacnePageInfo",finacnePageInfo);
        model.addAttribute("financeList",payMoneyList);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","paymoneyActive");


        return "admin/finance/paymoney";

    }

    @RequestMapping("/addPayMoney")
    @ResponseBody
    public Msg insertPayMoney(PayMoney payMoney){
        int i = payMoneyService.addPayMoney(payMoney);
        if(i == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }


    @RequestMapping("/getPayMoneyInfoById/{id}")
    @ResponseBody
    public Msg getPayMoneyInfoById(@PathVariable("id") Integer id){
        PayMoney payMoney = payMoneyService.selectPayMoneyById(id);
        return Msg.success().add("payMoney",payMoney);
    }

    @RequestMapping("/updatePayMoney/{id}")
    @ResponseBody
    public Msg updatePayMoneyAll(PayMoney payMoney){
        int i = payMoneyService.updatePayMoney(payMoney);
        if (i == 1){
            return Msg.success();
        }
        else{
            return Msg.fail();
        }
    }

    @RequestMapping("/deletePayMoneyById/{id}")
    @ResponseBody
    public Msg deletePayMoneyById(@PathVariable("id") Integer id){
        int i = payMoneyService.deletePayMoney(id);
        if(i == 1){
            return  Msg.success();
        }else{
            return Msg.fail();
        }

    }

}
