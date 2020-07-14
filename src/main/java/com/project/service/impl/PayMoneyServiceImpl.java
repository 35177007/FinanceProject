package com.project.service.impl;


import com.project.mapper.PayMoneyMapper;
import com.project.pojo.PayMoney;
import com.project.service.PayMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayMoneyServiceImpl implements PayMoneyService {

    @Autowired
    private PayMoneyMapper payMoneyMapper;

    @Override
    public List<PayMoney> selectPayMoneyAll() {
        return payMoneyMapper.selectPayMoneyAll();
    }

    @Override
    public int addPayMoney(PayMoney payMoney) {
        return payMoneyMapper.addPayMoney(payMoney);
    }

    @Override
    public PayMoney selectPayMoneyById(Integer id) {
        return payMoneyMapper.selectPayMoneyById(id);
    }

    @Override
    public int updatePayMoney(PayMoney payMoney) {
        return payMoneyMapper.updatePayMoney(payMoney);
    }

    @Override
    public int deletePayMoney(Integer id) {
        return payMoneyMapper.deletePayMoney(id);
    }
}
