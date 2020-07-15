package com.project.service.impl;

import com.project.mapper.UserChangeMapper;
import com.project.pojo.ChangeMoney;
import com.project.pojo.FlowOfFunds;
import com.project.pojo.UserChangeInfo;
import com.project.service.UserChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserChangeServiceImpl implements UserChangeService {

    @Autowired
    public UserChangeMapper userChangeMapper;

    @Override
    public List<ChangeMoney> selectUserChangeAll() {
        return userChangeMapper.selectUserChangeAll();
    }

    @Override
    public ChangeMoney selectUserChangeById(Integer id) {
        return userChangeMapper.selectUserChangeById(id);
    }

    @Override
    public int insertFlowOfFund(FlowOfFunds flowOfFunds) {
        return userChangeMapper.insertFlowOfFund(flowOfFunds);
    }

    @Override
    public int insertUserChange(UserChangeInfo userChangeInfo) {
        return userChangeMapper.insertUserChange(userChangeInfo);
    }


}
