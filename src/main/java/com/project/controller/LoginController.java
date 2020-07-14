package com.project.controller;


import com.project.common.Msg;
import com.project.pojo.Admin;
import com.project.pojo.User;
import com.project.service.LoginService;
import com.project.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller

public class LoginController {

    @Autowired

    private LoginServiceImpl loginService;

    @RequestMapping("/")
    public String loginMain(){

        return "login";
    }

    @RequestMapping("/login/loginVerifyUsername/{username}")
    @ResponseBody
    public Msg login(@PathVariable("username") String username, HttpServletRequest request){
        Admin admin = loginService.selectAdminByUserName(username);
        User user = loginService.selectUserByUserName(username);
        if(admin != null){
            request.getSession().setAttribute("username",admin.getUsername());
            return Msg.success();
        }
        if(user != null){
            request.getSession().setAttribute("username",user.getUsername());
            return Msg.success();
        }
        return Msg.fail();
    }

    @RequestMapping("/login/verifyLogin")
    @ResponseBody
    public Msg adminOrUserLogin(@RequestParam("username") String username,@RequestParam("password") String password,HttpServletRequest request)
    {
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        Admin loginAdmin = loginService.adminLogin(admin);
        if(loginAdmin != null ){
            request.getSession().setAttribute("admin",loginAdmin);
            loginService.setAdminStatus(admin);
            return Msg.success().add("url","/admin/main");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User loginUser = loginService.userLogin(user);
        if(loginUser != null ){
            request.getSession().setAttribute("user",loginUser);
            loginService.setUserStatus(user);
            return Msg.success().add("url","/user/main");
        }
        return Msg.fail();
    }


}
