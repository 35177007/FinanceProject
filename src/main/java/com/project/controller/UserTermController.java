package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.TermFinancial;
import com.project.pojo.FlowOfFunds;
import com.project.pojo.UserTermInfo;
import com.project.service.impl.UserTermServiceImpl;
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
public class UserTermController {
    @Autowired
    public UserTermServiceImpl userTermService;

    @RequestMapping("/finance/toTermFinancial")
    public String selectUserTermAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model){

        PageHelper.startPage(pageNum,pageSize);
        List<TermFinancial> termFinancialList = userTermService.selectUserTermAll();
        //PageInfo封装分页信息
        PageInfo<TermFinancial> finacnePageInfo = new PageInfo<TermFinancial>(termFinancialList);

        model.addAttribute("finacnePageInfo",finacnePageInfo);
        model.addAttribute("termFinancialList",termFinancialList);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","termFinancialActive");


        return "user/finance/termfinancial";


    }

    @RequestMapping("/getUserTermById/{id}")
    @ResponseBody
    public Msg selectUserTermById(@PathVariable("id") Integer id) {
        TermFinancial termFinancial = userTermService.selectUserTermById(id);
        return Msg.success().add("termFinancial",termFinancial);
    }

    @RequestMapping("/buyTermFinancial")
    @ResponseBody
    public Msg insertbuyTermFinancial(@RequestParam("termFinancialId") Integer termFinancialId,@RequestParam("userId") Integer userId) {
        Date utilDate  =new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        TermFinancial termFinancial = userTermService.selectUserTermById(termFinancialId);
        BigDecimal money = termFinancial.getLeastMoney();
        String name = termFinancial.getName();
        String desc = "无";
        FlowOfFunds flowOfFunds = new FlowOfFunds(null,userId,money,1,name,sqlDate,desc);

        int i = userTermService.insertFlowOfFund(flowOfFunds);
        BigDecimal averYield = termFinancial.getAnnualIncome();
        BigDecimal profit = money.multiply(averYield);
        UserTermInfo userTermInfo = new UserTermInfo(null,userId,termFinancialId,sqlDate,averYield,profit,1);

        int j = userTermService.insertUserTerm(userTermInfo);
        if(i == 1&&j == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }

    }

}
