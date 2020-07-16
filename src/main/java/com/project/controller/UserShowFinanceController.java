package com.project.controller;

import com.project.common.Msg;
import com.project.pojo.*;
import com.project.service.impl.UserSHowFinanceServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserShowFinanceController {
    @Autowired
    private UserSHowFinanceServiceImpl userSHowFinanceService;

    @RequestMapping("/user/personal/toMyFinance")
    public String userShowFinanceAll(Model model, HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        Integer id = user.getId();
        List<UserShowChange> userShowChanges = userSHowFinanceService.selectUserChange(id);
        List<UserShowFund> userShowFunds = userSHowFinanceService.selectUserFund(id);
        List<UserShowPay> userShowPays = userSHowFinanceService.selectUserPay(id);
        List<UserShowTerm> userShowTerms = userSHowFinanceService.selectUserTerm(id);
        model.addAttribute("userChangeMoneyList",userShowChanges);
        model.addAttribute("userFundProductList",userShowFunds);
        model.addAttribute("userPayMoneyList",userShowPays);
        model.addAttribute("userTermFinancialList",userShowTerms);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl","userInfoActive");
        model.addAttribute("activeUrl2","userInfoActive");
        return "user/personal/myfinance";
    }
    @RequestMapping("/user/revokeUserChangeMoney")
    @ResponseBody
    public Msg removeChange(@RequestParam(value = "userChangeMoneyId") Integer id){
        int i = userSHowFinanceService.removeUserChange(id);
        if(i == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/user/revokeUserPayMoney")
    @ResponseBody
    public Msg removePay(@RequestParam(value = "userPayMoneyId") Integer id){
        int i = userSHowFinanceService.removeUserPay(id);
        if(i == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/user/revokeUserTermFinancial")
    @ResponseBody
    public Msg removeTerm(@RequestParam(value = "userTermFinancialId") Integer id){
        int i = userSHowFinanceService.removeUserTerm(id);
        if(i == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
    @RequestMapping("/user/revokeUserFundProduct")
    @ResponseBody
    public Msg removeFund(@RequestParam(value = "userFundProductId") Integer id){
        int i = userSHowFinanceService.removeUserFund(id);
        if(i == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
