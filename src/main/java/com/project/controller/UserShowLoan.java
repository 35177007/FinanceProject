package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.Loan;
import com.project.pojo.User;
import com.project.service.impl.LoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserShowLoan {
    @Autowired
    private LoanServiceImpl loanService;

    @RequestMapping("/user/personal/toMyLoan")
    public String showLoan(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model, HttpServletRequest request){

        PageHelper.startPage(pageNum,pageSize);
        User user = (User)request.getSession().getAttribute("user");
        Integer id = user.getId();
        List<Loan> loans = loanService.selectLoanById(id);
        //PageInfo封装分页信息
        PageInfo<Loan> pageInfo = new PageInfo<Loan>(loans);
        model.addAttribute("myLoansPageInfo",pageInfo);
        model.addAttribute("loansList",loans);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","myFinanceActive");
        model.addAttribute("activeUrl2","myLoanActive");
        return "user/personal/myloan";
    }
    @RequestMapping("/user/repayment/{id}")
    @ResponseBody
    public Msg userrepay(@PathVariable("id") Integer id){
        int i = loanService.repayLoan(id);
        if(i == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
