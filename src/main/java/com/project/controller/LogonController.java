package com.project.controller;

import com.project.common.Msg;
import com.project.pojo.Admin;
import com.project.pojo.User;
import com.project.service.impl.LoginServiceImpl;
import com.project.service.impl.LogonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class LogonController {
    @Autowired
    private LogonServiceImpl logonService;
    @RequestMapping("/logon")
    public String logOn(){
        return "register";

    }

    @RequestMapping("/logon/register")
    @ResponseBody
    public Msg logonInsert(User user){
        int i = logonService.logonInsert(user);
        if (i == 1){
            return Msg.success().add("url","/");
        }
        else{
            return Msg.fail();
        }
    }


}
