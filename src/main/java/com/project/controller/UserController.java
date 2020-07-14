package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.User;
import com.project.service.UserService;
import com.project.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/userinfo")
    public String selectUserAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model){


        //引入分页信息
        //首先引入PageHelper插件
        PageHelper.startPage(pageNum,pageSize);
        List<User> list = userServiceImpl.selectUserAll();
        //PageInfo封装分页信息
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        model.addAttribute("userPageInfo",pageInfo);
        model.addAttribute("list",list);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl","userInfoActive");
        model.addAttribute("activeUrl2","userInfoActive");


        return "admin/userinfo/userinfo";
    }

    @RequestMapping("/user/addUser")
    @ResponseBody//加入这个注解之后如果返回字符串 不再返回视图解析  而是返回返回值类型的数据
    public Msg insertUser(User user){

        int i = userServiceImpl.addUser(user);
        if(i == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/user/getUserById/{id}")
    @ResponseBody
    public Msg getUserInfoById(@PathVariable("id") Integer id){
        User user = userServiceImpl.selectUserById(id);
        return Msg.success().add("user",user);
    }

    @RequestMapping("/user/deleteUserById/{id}")
    @ResponseBody
    public Msg deleteUserById(@PathVariable("id") Integer id){
        int i = userServiceImpl.deleteUser(id);
        if(i == 1){
            return  Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @RequestMapping("/user/updateUserProfile/{id}")
    @ResponseBody
    public Msg updateUserProfile(User user){
        int i = userServiceImpl.updateUser(user);
        if (i == 1){
            return Msg.success();
        }
        else{
            return Msg.fail();
        }
    }

}
