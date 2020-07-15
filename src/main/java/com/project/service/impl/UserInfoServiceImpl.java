package com.project.service.impl;

import com.project.mapper.UserInfoMapper;
import com.project.pojo.UserInfo;
import com.project.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> selectUserInfo(Integer id) {
        return userInfoMapper.selectUserInfo(id);
    }

    @Override
    public int updateInfo(Integer id) {
        return userInfoMapper.updateInfo(id);
    }

    @Override
    public int userDeleteInfo(Integer id) {
        return userInfoMapper.userDeleteInfo(id);
    }
}
