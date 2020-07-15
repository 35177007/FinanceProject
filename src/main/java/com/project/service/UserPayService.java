package com.project.service;

import com.project.pojo.FlowOfFunds;
import com.project.pojo.PayMoney;
import com.project.pojo.UserPayInfo;

import java.util.List;

public interface UserPayService {

    public List<PayMoney> selectUserPayAll();

    public PayMoney selectUserPayById(Integer id);

    public int insertUserPay(UserPayInfo userPayInfo);

    public int insertFlowOfFund(FlowOfFunds flowOfFunds);
}
