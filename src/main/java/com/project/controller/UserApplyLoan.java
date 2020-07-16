package com.project.controller;

import com.project.common.Msg;
import com.project.pojo.Admin;
import com.project.pojo.Info;
import com.project.pojo.Loan;
import com.project.pojo.User;
import com.project.service.impl.UserApplyLoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class UserApplyLoan {
    @Autowired
    private UserApplyLoanServiceImpl userApplyLoanService;

    @RequestMapping("/user/tools/toApplyLoan")
    public String show(Model model){
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","toolsActive");
        model.addAttribute("activeUrl2","applyLoanActive");
        return "user/tools/applyloan";
    }

    @RequestMapping("/user/applyLoan")
    @ResponseBody
    public Msg adminOrUserLogin(@RequestParam("amount") Double amount, @RequestParam("term") Integer term,@RequestParam("rate") Double rate, HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user");
        Integer userId = user.getId();
        Date utilDate  =new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Loan loan = new Loan(userId, null, sqlDate, amount, term, rate, 0, 0, null, null);

        int i = userApplyLoanService.applyLoan(loan);
        if(i == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
