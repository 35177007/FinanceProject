package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.User;
import com.project.service.impl.AdminMainServiceImpl;
import com.project.service.impl.UserServiceImpl;
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
public class AdminMainController {
    @Autowired
    private AdminMainServiceImpl adminMainService;

    @RequestMapping("/admin/main")
    public String selectUserAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model){

        //引入分页信息
        //首先引入PageHelper插件
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList = adminMainService.selectUserAll();
        //PageInfo封装分页信息
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        model.addAttribute("userPageInfo",pageInfo);
        model.addAttribute("userList",userList);
        model.addAttribute("activeUrl","indexActive");

        return "admin/main";
    }

    @RequestMapping("/user/updateUserStatus/{id}")
    @ResponseBody
    public Msg goOffline(@PathVariable("id") Integer id, HttpServletRequest request){
        int i = adminMainService.goOffline(id);
        request.getSession().removeAttribute("user");
        if(i == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
