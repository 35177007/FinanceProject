package com.project.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.FundProduct;
import com.project.pojo.FlowOfFunds;
import com.project.pojo.UserChangeInfo;
import com.project.pojo.UserFundInfo;
import com.project.service.impl.UserFundServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Controller
@RequestMapping("/user")
public class UserFundController {
    @Autowired
    public UserFundServiceImpl userFundService;

    @RequestMapping("/finance/toFundProduct")
    public String selectUserFundAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize, Model model){

        PageHelper.startPage(pageNum,pageSize);
        List<FundProduct> fundProductList = userFundService.selectUserFundAll();
        //PageInfo封装分页信息
        PageInfo<FundProduct> finacnePageInfo = new PageInfo<FundProduct>(fundProductList);

        model.addAttribute("finacnePageInfo",finacnePageInfo);
        model.addAttribute("fundProductList",fundProductList);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl","userInfoActive");
        model.addAttribute("activeUrl2","userInfoActive");


        return "user/finance/fundproduct";

    }

    @RequestMapping("/getUserFundById/{id}")
    @ResponseBody
    public Msg selectUserFundById(@PathVariable("id") Integer id) {
        FundProduct fundMoney = userFundService.selectUserFundById(id);
        return Msg.success().add("fundMoney",fundMoney);
    }

    @RequestMapping("/buyFundProduct")
    @ResponseBody
    public Msg insertbuyFundProduct(@RequestParam("fundProductId") Integer fundProductId,@RequestParam("userId") Integer userId) {
        Date utilDate  =new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        FundProduct fundMoney = userFundService.selectUserFundById(fundProductId);
        BigDecimal money = fundMoney.getLeastMoney();
        String name = fundMoney.getFundDesc();
        String desc = "无";
        FlowOfFunds flowOfFunds = new FlowOfFunds(null,userId,money,1,name,sqlDate,desc);
        int i = userFundService.insertFlowOfFund(flowOfFunds);
        BigDecimal averYield = fundMoney.getMonthlyGrowth();
        BigDecimal profit = money.multiply(averYield);
        UserFundInfo userFundInfo = new UserFundInfo(null,userId,fundProductId,sqlDate,averYield,profit,1);
        int j = userFundService.insertUserFund(userFundInfo);
        if(i == 1&&j == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }
}
