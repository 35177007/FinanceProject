package com.project.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.TermFinancial;
import com.project.service.TermFinancialService;
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
public class TermFinancialController {
    @Autowired
    private TermFinancialService termFinancialService;

    @RequestMapping("/finance/toTermFinancial")
    public String selectPayMoney(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model){

        PageHelper.startPage(pageNum,pageSize);
        List<TermFinancial> termFinancialList = termFinancialService.selectTermFinancialAll();
        //PageInfo封装分页信息
        PageInfo<TermFinancial> finacnePageInfo = new PageInfo<TermFinancial>(termFinancialList);

        model.addAttribute("finacnePageInfo",finacnePageInfo);
        model.addAttribute("financeList",termFinancialList);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl","userInfoActive");
        model.addAttribute("activeUrl2","userInfoActive");
        model.addAttribute("username", "username");

        return "admin/finance/termfinancial";

    }


    @RequestMapping("/addTermFinancial")
    @ResponseBody
    public Msg insertTermFinancial(TermFinancial termFinancial){
        int i = termFinancialService.addTermFinancial(termFinancial);
        if(i == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }


    @RequestMapping("/getTermFinancialInfoById/{id}")
    @ResponseBody
    public Msg getTermFinancialInfoById(@PathVariable("id") Integer id){
        TermFinancial termFinancial= termFinancialService.selectTermFinancialById(id);
        return Msg.success().add("termFinancial",termFinancial);
    }

    @RequestMapping("/updateTermFinancial/{id}")
    @ResponseBody
    public Msg updateTermFinancialAll(TermFinancial termFinancial){
        int i = termFinancialService.updateTermFinancial(termFinancial);
        if (i == 1){
            return Msg.success();
        }
        else{
            return Msg.fail();
        }
    }

    @RequestMapping("/deleteTermFinancialById/{id}")
    @ResponseBody
    public Msg deleteTermFinancialById(@PathVariable("id") Integer id){
        int i = termFinancialService.deleteTermFinancial(id);
        if(i == 1){
            return  Msg.success();
        }else{
            return Msg.fail();
        }

    }
}
