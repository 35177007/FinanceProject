package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.User;
import com.project.pojo.UserInfo;
import com.project.service.impl.LoanInfoServiceImpl;
import com.project.service.impl.UserInfoServiceImpl;
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
public class UserInfoController {

    @Autowired
    private UserInfoServiceImpl userInfoService;

    @RequestMapping("/user/personal/toMyInfo")
    public String showMyInfo(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model,HttpServletRequest request){

        User user = (User)request.getSession().getAttribute("user");
        Integer userId = user.getId();
        List<UserInfo> userInfos = userInfoService.selectUserInfo(userId);
        PageHelper.startPage(pageNum,pageSize);

        //PageInfo封装分页信息
        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(userInfos);
        model.addAttribute("infoPageInfo",pageInfo);
        model.addAttribute("infoList",userInfos);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl","userInfoActive");
        model.addAttribute("activeUrl2","userInfoActive");
        return "user/personal/myinfo";
    }
    @RequestMapping("/user/updateInfo/{infoId}")
    @ResponseBody
    public Msg userInfoUpdate(@PathVariable("infoId") Integer id){
        int i = userInfoService.updateInfo(id);
        if(i == 1){
            return  Msg.success();
        }else{
            return Msg.fail();
        }
    }
    @RequestMapping("/user/deleteInfo/{infoId}")
    @ResponseBody
    public Msg userInfoDelete(@PathVariable("infoId") Integer id){
        int i = userInfoService.userDeleteInfo(id);
        if(i == 1){
            return  Msg.success();
        }else{
            return Msg.fail();
        }
    }
}

