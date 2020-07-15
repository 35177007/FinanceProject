package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.Admin;
import com.project.pojo.Info;
import com.project.pojo.Loan;
import com.project.pojo.User;
import com.project.service.impl.LoanInfoServiceImpl;
import com.project.service.impl.LoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/loan")
public class LoanController {
    @Autowired
    private LoanServiceImpl loanService;
    @Autowired
    private LoanInfoServiceImpl loanInfoService;

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
    public Msg passapplyStatus(@RequestParam("username") String username,@RequestParam("amount") Float amount,@RequestParam("userId") Integer userId,@PathVariable("id") Integer id, HttpServletRequest request){
        Loan loan = new Loan();
        loan.setId(id);
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        Integer examId = admin.getId();
        loan.setExamineId(examId);
        int i = loanService.passApplyStatus(loan);
        Admin admin1 = (Admin)request.getSession().getAttribute("admin");
        Integer examId1 = admin1.getId();
        String username1 = admin1.getUsername();
        Date utilDate  =new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        String message = "用户"+username+"申请的"+amount+"网贷申请审核通过！审核人为："+username1;
        Info info = new Info(examId1, userId, "网贷审核通过", sqlDate, message, 0);
        int j = loanInfoService.insertLoadInfo(info);
        if (i == 1&&j==1){
            return Msg.success();
        }
        else{
            return Msg.fail();
        }
    }

    @RequestMapping("/notPassapplyStatus/{id}")
    @ResponseBody
    public Msg notPassapplyStatus(@RequestParam("username") String username,@RequestParam("amount") Float amount,@RequestParam("userId") Integer userId,@PathVariable("id") Integer id, HttpServletRequest request){
        Loan loan = new Loan();
        loan.setId(id);
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        Integer examId = admin.getId();
        loan.setExamineId(examId);
        int i = loanService.notPassapplyStatus(loan);
        Admin admin1 = (Admin)request.getSession().getAttribute("admin");
        Integer examId1 = admin1.getId();
        String username1 = admin1.getUsername();
        Date utilDate  =new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        String message = "用户"+username+"申请的"+amount+"网贷申请审核未通过！审核人为："+username1;
        Info info = new Info(examId1, userId, "网贷审核未通过", sqlDate, message, 0);
        int j = loanInfoService.insertLoadInfo(info);
        if (i == 1&&j==1){
            return Msg.success();
        }
        else{
            return Msg.fail();
        }
    }


}
