package com.project.controller;

import com.project.common.Msg;
import com.project.pojo.User;
import com.project.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserSecurityController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/user/personal/toSecurity")
    public String showSecurity(Model model){
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","personalActive");
        model.addAttribute("activeUrl2","securityActive");
        return "user/personal/security";
    }
    @RequestMapping("/user/updatePwd")
    @ResponseBody
    public Msg updatePwd(@RequestParam("oldpwd") String oldpwd, @RequestParam("id") Integer id, @RequestParam("newpwd") String  newpwd, HttpServletRequest request){

        User user1 = userService.selectUserById(id);
        String password = user1.getPassword();
        if (!(oldpwd.equals(password))) {
            return Msg.fail();
        }
        User user = new User();
        user.setPassword(newpwd);
        user.setId(id);
        int i = userService.setPwd(user);
        if (i == 1){
            return Msg.success();
        }
        else{
            return Msg.fail();
        }
    }
}
