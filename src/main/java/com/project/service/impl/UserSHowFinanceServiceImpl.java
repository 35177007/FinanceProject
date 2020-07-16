package com.project.service.impl;

import com.project.mapper.UserShowFinanceMapper;
import com.project.pojo.UserShowChange;
import com.project.pojo.UserShowFund;
import com.project.pojo.UserShowPay;
import com.project.pojo.UserShowTerm;
import com.project.service.UserShowFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserSHowFinanceServiceImpl implements UserShowFinanceService {
    @Autowired
    private UserShowFinanceMapper userShowFinanceMapper;

    @Override
    public List<UserShowFund> selectUserFund(Integer id) {
        return userShowFinanceMapper.selectUserFund(id);
    }

    @Override
    public List<UserShowChange> selectUserChange(Integer id) {
        return userShowFinanceMapper.selectUserChange(id);
    }

    @Override
    public List<UserShowPay> selectUserPay(Integer id) {
        return userShowFinanceMapper.selectUserPay(id);
    }

    @Override
    public List<UserShowTerm> selectUserTerm(Integer id) {
        return userShowFinanceMapper.selectUserTerm(id);
    }

    @Override
    public int removeUserPay(Integer id) {
        return userShowFinanceMapper.removeUserPay(id);
    }

    @Override
    public int removeUserTerm(Integer id) {
        return userShowFinanceMapper.removeUserTerm(id);
    }

    @Override
    public int removeUserChange(Integer id) {
        return userShowFinanceMapper.removeUserChange(id);
    }

    @Override
    public int removeUserFund(Integer id) {
        return userShowFinanceMapper.removeUserFund(id);
    }
}
