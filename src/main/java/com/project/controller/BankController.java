package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.Bank;
import com.project.service.impl.BankServiceImpl;
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
public class BankController {
    @Autowired
    private BankServiceImpl bankService;

    @RequestMapping("/finance/toBank")
    public String selectBankAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model){
        //引入分页信息
        //首先引入PageHelper插件
        PageHelper.startPage(pageNum,pageSize);
        List<Bank> financeList = bankService.selectBankAll();
        //PageInfo封装分页信息
        PageInfo<Bank> pageInfo = new PageInfo<Bank>(financeList);
        model.addAttribute("financePageInfo",pageInfo);
        model.addAttribute("financeList",financeList);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl","BankInfoActive");
        model.addAttribute("activeUrl2","BankInfoActive");

        return "admin/finance/bank";
    }

    @RequestMapping("/addBank")
    @ResponseBody//加入这个注解之后如果返回字符串 不再返回视图解析  而是返回返回值类型的数据
    public Msg insertBank(Bank bank){
        int i = bankService.addBank(bank);
        if(i == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/getBankInfoById/{id}")
    @ResponseBody
    public Msg getBankInfoById(@PathVariable("id") Integer id){
        Bank bank = bankService.selectBankById(id);
        return Msg.success().add("bank",bank);
    }

    @RequestMapping("/deleteBankById/{id}")
    @ResponseBody
    public Msg deleteBankById(@PathVariable("id") Integer id){
        int i = bankService.deleteBank(id);
        if(i == 1){
            return  Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @RequestMapping("/updateBank/{id}")
    @ResponseBody
    public Msg updateBankProfile(Bank bank){
        int i = bankService.updateBank(bank);
        if (i == 1){
            return Msg.success();
        }
        else{
            return Msg.fail();
        }
    }

}
