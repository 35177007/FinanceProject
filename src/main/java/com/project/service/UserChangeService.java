package com.project.service;

import com.project.pojo.ChangeMoney;
import com.project.pojo.FlowOfFunds;
import com.project.pojo.UserChangeInfo;

import java.util.List;

public interface UserChangeService {
    public List<ChangeMoney> selectUserChangeAll();
    public ChangeMoney selectUserChangeById(Integer id);
    public int insertFlowOfFund(FlowOfFunds flowOfFunds);
    public int insertUserChange(UserChangeInfo userChangeInfo);
}
