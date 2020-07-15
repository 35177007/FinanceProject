package com.project.controller;

import com.project.common.Msg;
import com.project.pojo.User;
import com.project.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserProfileConrtoller {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/user/personal/toProfile")

    public String UserProfile(Model model, HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        User user1 = userService.selectUserById(user.getId());
        model.addAttribute("user",user1);
        return "/user/personal/profile";
    }
    @RequestMapping("/user/updateUserProfile/{id}")
    @ResponseBody
    public Msg userUpdate(User user,Model model){
        int i = userService.updateUserById(user);

        if (i == 1){
            return Msg.success();
        }
        else{
            return Msg.fail();
        }
    }
}
