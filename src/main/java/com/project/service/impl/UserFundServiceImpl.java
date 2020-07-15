package com.project.service.impl;

import com.project.mapper.UserFundMapper;
import com.project.pojo.FlowOfFunds;
import com.project.pojo.FundProduct;
import com.project.pojo.UserFundInfo;
import com.project.service.UserFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFundServiceImpl implements UserFundService {

    @Autowired
    public UserFundMapper userFundMapper;

    @Override
    public List<FundProduct> selectUserFundAll() {
        return userFundMapper.selectUserFundAll();
    }

    @Override
    public FundProduct selectUserFundById(Integer id) {
        return userFundMapper.selectUserFundById(id);
    }

    @Override
    public int insertFlowOfFund(FlowOfFunds flowOfFunds) {
        return userFundMapper.insertFlowOfFund(flowOfFunds);
    }

    @Override
    public int insertUserFund(UserFundInfo userFundInfo) {
        return userFundMapper.insertUserFund(userFundInfo);
    }
}
