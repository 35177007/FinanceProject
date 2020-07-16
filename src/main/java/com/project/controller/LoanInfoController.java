package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.Admin;
import com.project.pojo.Info;
import com.project.pojo.LoanInfo;
import com.project.pojo.User;
import com.project.service.impl.LoanInfoServiceImpl;
import com.project.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class LoanInfoController {
    @Autowired
    private LoanInfoServiceImpl loanInfoService;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/loan/toLoaninfo")
    public String selectLoanInfoAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model){


        //引入分页信息
        //首先引入PageHelper插件
        PageHelper.startPage(pageNum,pageSize);

        List<LoanInfo> loanInfos = loanInfoService.selectLoanInfoAll();
        //PageInfo封装分页信息
        PageInfo<LoanInfo> loanPageInfo = new PageInfo<LoanInfo>(loanInfos);
        model.addAttribute("loanPageInfo",loanPageInfo);
        model.addAttribute("loanList",loanInfos);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","loanActive");
        model.addAttribute("activeUrl2","loaninfoActive");


        return "admin/loan/loaninfo";
    }
    @RequestMapping("/loan/remindPay/{id}")
    @ResponseBody
    public Msg insertLoadInfo(@RequestParam("username") String username,@RequestParam("amount") Float amount,@PathVariable("id") Integer id, HttpServletRequest request){
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        Integer examId = admin.getId();
        String username1 = admin.getUsername();
        Date utilDate  =new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        String message = "用户"+username+"申请的"+amount+"元网贷该还款了！该提醒发送人为："+username1;
        Info info = new Info(examId, id, "还款通知", sqlDate, message, 0);
        int i = loanInfoService.insertLoadInfo(info);
        if(i == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
