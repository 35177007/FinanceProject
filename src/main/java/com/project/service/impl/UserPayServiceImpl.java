package com.project.service.impl;

import com.project.mapper.UserPayMapper;
import com.project.pojo.*;
import com.project.service.UserPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserPayServiceImpl implements UserPayService {

    @Autowired
    public UserPayMapper userPayMapper;

    @Override
    public List<PayMoney> selectUserPayAll() {
        return userPayMapper.selectUserPayAll();
    }

    @Override
    public PayMoney selectUserPayById(Integer id) {
        return userPayMapper.selectUserPayById(id);
    }

    @Override
    public int insertFlowOfFund(FlowOfFunds flowOfFunds) {
        return userPayMapper.insertFlowOfFund(flowOfFunds);
    }

    @Override
    public int insertUserPay(UserPayInfo userPayInfo) {
        return userPayMapper.insertUserPay(userPayInfo);
    }
}
