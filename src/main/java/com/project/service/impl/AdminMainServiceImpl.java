package com.project.service.impl;

import com.project.mapper.AdminMainMapper;
import com.project.mapper.UserMapper;
import com.project.pojo.User;
import com.project.service.AdminMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminMainServiceImpl implements AdminMainService {

    @Autowired
    private AdminMainMapper adminMainMapper;

    @Override
    public List<User> selectUserAll() {
        return adminMainMapper.selectUserAll();
    }

    @Override
    public int goOffline(Integer id) {
        return adminMainMapper.goOffline(id);
    }
}
