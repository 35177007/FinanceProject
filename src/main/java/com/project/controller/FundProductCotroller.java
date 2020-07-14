package com.project.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.FundProduct;
import com.project.service.FundProductService;
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
public class FundProductCotroller {

    @Autowired
    private FundProductService fundProductService;

    @RequestMapping("/finance/toFundProduct")
    public String selectPayMoney(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model){

        PageHelper.startPage(pageNum,pageSize);
        List<FundProduct> fundProductList = fundProductService.selectFundProductAll();
        //PageInfo封装分页信息
        PageInfo<FundProduct> finacnePageInfo = new PageInfo<FundProduct>(fundProductList);

        model.addAttribute("finacnePageInfo",finacnePageInfo);
        model.addAttribute("financeList",fundProductList);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl","userInfoActive");
        model.addAttribute("activeUrl2","userInfoActive");
        model.addAttribute("username", "username");

        return "admin/finance/fundproduct";

    }


    @RequestMapping("/addFundProduct")
    @ResponseBody
    public Msg insertFundProduct(FundProduct fundProduct){
        int i = fundProductService.addFundProduct(fundProduct);
        if(i == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }


    @RequestMapping("/getFundProductInfoById/{id}")
    @ResponseBody
    public Msg getFundProductById(@PathVariable("id") Integer id){
        FundProduct fundProduct = fundProductService.selectFundProductById(id);
        return Msg.success().add("fundProduct",fundProduct);
    }

    @RequestMapping("/updateFundProduct/{id}")
    @ResponseBody
    public Msg updateFundProductAll(FundProduct fundProduct){
        int i = fundProductService.updateFundProduct(fundProduct);
        if (i == 1){
            return Msg.success();
        }
        else{
            return Msg.fail();
        }
    }

    @RequestMapping("/deleteFundProductById/{id}")
    @ResponseBody
    public Msg deleteFundProductById(@PathVariable("id") Integer id){
        int i = fundProductService.deleteFundProduct(id);
        if(i == 1){
            return  Msg.success();
        }else{
            return Msg.fail();
        }

    }
}
