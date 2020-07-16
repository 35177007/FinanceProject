package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.Admin;
import com.project.pojo.BankCard;
import com.project.pojo.User;
import com.project.service.UserCardService;
import com.project.service.impl.UserCardServiceImpl;
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
@RequestMapping("/user")
public class UserCardController {

    @Autowired
    public UserCardServiceImpl userCardService;

    @RequestMapping("/personal/toBankCard")
    public String selectCardAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model,HttpServletRequest request){
        User admin = (User)request.getSession().getAttribute("user");
        Integer examId = admin.getId();
        PageHelper.startPage(pageNum,pageSize);
        List<BankCard> bankCardList = userCardService.selectCardAll(examId);
        //PageInfo封装分页信息
        PageInfo<BankCard> bankCardPageInfo = new PageInfo<BankCard>(bankCardList);

        model.addAttribute("bankcardPageInfo",bankCardPageInfo);
        model.addAttribute("bankCardList",bankCardList);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl","userInfoActive");
        model.addAttribute("activeUrl2","userInfoActive");


        return "user/personal/bankcard";

    }

    @RequestMapping("/addBankCard")
    @ResponseBody
    public Msg insertCard(BankCard bankCard,HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        Integer examId = user.getId();
        bankCard.setUserId(examId);
        int i = userCardService.addCard(bankCard);
        if(i == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    @RequestMapping("/getBankCardById/{id}")
    @ResponseBody
    public Msg getCardById(@PathVariable("id") Integer id){
        BankCard bankCard = userCardService.selectCardById(id);
        return Msg.success().add("bankcard",bankCard);
    }

    @RequestMapping("/deleteBankCard/{id}")
    @ResponseBody
    public Msg deleteCardById(@PathVariable("id") Integer id){
        int i = userCardService.deleteCardById(id);
        if(i == 1){
            return  Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @RequestMapping("/updateBankCard/{id}")
    @ResponseBody
    public Msg updateCardById(BankCard bankCard){
        int i = userCardService.updateCard(bankCard);
        if (i == 1){
            return Msg.success();
        }
        else{
            return Msg.fail();
        }
    }

}
