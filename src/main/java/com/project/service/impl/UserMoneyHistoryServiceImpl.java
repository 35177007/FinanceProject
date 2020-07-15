package com.project.service.impl;

import com.project.mapper.UserMoneyHistoryMapper;
import com.project.pojo.UserMoneyHistory;
import com.project.service.UserMoneyHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMoneyHistoryServiceImpl implements UserMoneyHistoryService {
    @Autowired
    private UserMoneyHistoryMapper userMoneyHistoryMapper;

    @Override
    public List<UserMoneyHistory> selectUserMoneyHistory(Integer id) {
        return userMoneyHistoryMapper.selectUserMoneyHistory(id);
    }
}
