package com.project.service.impl;

import com.project.mapper.UserTermMapper;
import com.project.pojo.TermFinancial;
import com.project.pojo.FlowOfFunds;
import com.project.pojo.UserTermInfo;
import com.project.service.UserTermServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserTermServiceImpl implements UserTermServce {

    @Autowired
    public UserTermMapper userTermMapper;

    @Override
    public List<TermFinancial> selectUserTermAll() {
        return userTermMapper.selectUserTermAll();
    }

    @Override
    public TermFinancial selectUserTermById(Integer id) {
        return userTermMapper.selectUserTermById(id);
    }

    @Override
    public int insertFlowOfFund(FlowOfFunds flowOfFunds) {
        return userTermMapper.insertFlowOfFund(flowOfFunds);
    }

    @Override
    public int insertUserTerm(UserTermInfo userTermInfo) {
        return userTermMapper.insertUserTerm(userTermInfo);
    }
    
}
