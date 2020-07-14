package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.Admin;
import com.project.pojo.Loan;
import com.project.pojo.User;
import com.project.service.impl.LoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/loan")
public class LoanController {
    @Autowired
    private LoanServiceImpl loanService;

    @RequestMapping("/toLoanexam")
    public String selectUserAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model){


        //引入分页信息
        //首先引入PageHelper插件
        PageHelper.startPage(pageNum,pageSize);
        List<Loan> loans = loanService.selectLoanAll();
        //PageInfo封装分页信息
        PageInfo<Loan> loanPageInfo = new PageInfo<Loan>(loans);
        model.addAttribute("loanPageInfo",loanPageInfo);
        model.addAttribute("loanList",loans);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl","userInfoActive");
        model.addAttribute("activeUrl2","userInfoActive");


        return "admin/loan/loanexam";
    }

    @RequestMapping("/passapplyStatus/{id}")
    @ResponseBody
    public Msg passapplyStatus(@PathVariable("id") Integer id, HttpServletRequest request){
        Loan loan = new Loan();
        loan.setId(id);
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        Integer examId = admin.getId();
        loan.setExamineId(examId);
        int i = loanService.passApplyStatus(loan);
        if (i == 1){
            return Msg.success();
        }
        else{
            return Msg.fail();
        }
    }

    @RequestMapping("/notPassapplyStatus/{id}")
    @ResponseBody
    public Msg notPassapplyStatus(@PathVariable("id") Integer id, HttpServletRequest request){
        Loan loan = new Loan();
        loan.setId(id);
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        Integer examId = admin.getId();
        loan.setExamineId(examId);
        int i = loanService.notPassapplyStatus(loan);
        if (i == 1){
            return Msg.success();
        }
        else{
            return Msg.fail();
        }
    }


}
