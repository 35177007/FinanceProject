package com.project.service;

import com.project.pojo.UserMoneyHistory;

import java.util.List;

public interface UserMoneyHistoryService {
    public List<UserMoneyHistory> selectUserMoneyHistory(Integer id);
}
