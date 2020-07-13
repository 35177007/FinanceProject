package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.BankCard;
import com.project.pojo.User;
import com.project.service.impl.BankCardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Action;
import java.util.List;

@Controller
@RequestMapping("/admin/userinfo")
public class BankCardController {
   @Autowired
    private BankCardServiceImpl bankCardService;

   @RequestMapping("/toBankCard")
    public String selectBankCardAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model){

       PageHelper.startPage(pageNum,pageSize);
       List<BankCard> bankcardList = bankCardService.selectBankCardAll();
       //PageInfo封装分页信息
       PageInfo<BankCard> bankCardPageInfo = new PageInfo<BankCard>(bankcardList);

       model.addAttribute("bankcardPageInfo",bankCardPageInfo);
       model.addAttribute("bankcardList",bankcardList);
       model.addAttribute("activeUrl","indexActive");
       model.addAttribute("activeUrl","userInfoActive");
       model.addAttribute("activeUrl2","userInfoActive");
       model.addAttribute("username","username");

       return "admin/userinfo/bankcard";

    }

    @RequestMapping("/user/deleteBankCard/{id}")
    @ResponseBody
   public Msg deleteBankCardById(@PathVariable("id") Integer id){
      int i = bankCardService.deleteBankCard(id);
       if(i == 1){
          return  Msg.success();
       }else{
          return Msg.fail();
       }
    }
    @RequestMapping("/user/getBankCardById/{id}")
    @ResponseBody
   public Msg getBankCardById(@PathVariable("id") Integer id){

      BankCard bankCard = bankCardService.selectBankCardById(id);
       return Msg.success().add("bankcard",bankCard);
    }

    @RequestMapping("/user/updateBankCard/{id}")
    @ResponseBody
   public Msg updateBanCardById(BankCard bankCard){
      int i = bankCardService.updateBankCard(bankCard);
       if(i == 1){
          return  Msg.success();
       }else{
          return Msg.fail();
       }
    }


}
