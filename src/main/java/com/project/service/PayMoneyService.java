package com.project.service;

import com.project.pojo.PayMoney;

import java.util.List;

public interface PayMoneyService {

    public List<PayMoney> selectPayMoneyAll();

    public int addPayMoney(PayMoney payMoney);

    public PayMoney selectPayMoneyById(Integer id);

    public int updatePayMoney(PayMoney payMoney);

    public int deletePayMoney(Integer id);
}
