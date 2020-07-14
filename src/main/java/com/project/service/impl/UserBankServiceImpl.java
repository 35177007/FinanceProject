package com.project.service.impl;

import com.project.mapper.UserBankMapper;
import com.project.pojo.Bank;
import com.project.service.UserBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserBankServiceImpl implements UserBankService {

    @Autowired
    private UserBankMapper userBankMapper;

    @Override
    public List<Bank> selectBankAll() {
        return userBankMapper.selectBankAll();
    }
}
