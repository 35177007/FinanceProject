package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.ChangeMoney;
import com.project.pojo.Reputation;
import com.project.service.ChangeMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ChangeMoneyController {
    @Autowired
    private ChangeMoneyService changeMoneyService;


    @RequestMapping("/finance/toChangeMoney")
    public String selectChangeMoney(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model){

        PageHelper.startPage(pageNum,pageSize);
        List<ChangeMoney> changeMoneyList = changeMoneyService.selectChangeMoneyAll();
        //PageInfo封装分页信息
        PageInfo<ChangeMoney> finacnePageInfo = new PageInfo<ChangeMoney>(changeMoneyList);

        model.addAttribute("finacnePageInfo",finacnePageInfo);
        model.addAttribute("financeList",changeMoneyList);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl","userInfoActive");
        model.addAttribute("activeUrl2","userInfoActive");
        model.addAttribute("username", "username");

        return "admin/finance/changemoney";

    }

    @RequestMapping("/addChangeMoney")
    @ResponseBody
    public Msg insertChangeMoney(ChangeMoney changeMoney){
        int i = changeMoneyService.addChangeMoney(changeMoney);
        if(i == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
