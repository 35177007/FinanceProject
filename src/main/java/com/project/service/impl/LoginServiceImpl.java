package com.project.service.impl;

import com.project.mapper.LoginMapper;
import com.project.pojo.Admin;
import com.project.pojo.User;
import com.project.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;
    @Override
    public Admin selectAdminByUserName(String username) {
        return loginMapper.selectAdminByUserName(username);
    }

    @Override
    public User selectUserByUserName(String username) {
        return loginMapper.selectUserByUserName(username);
    }

    @Override
    public Admin adminLogin(Admin admin) {
        return loginMapper.adminLogin(admin);
    }

    @Override
    public User userLogin(User user) {
        return loginMapper.userLogin(user);
    }

    @Override
    public void setUserStatus(User user) {
        loginMapper.setUserStatus(user);
    }

    @Override
    public void setAdminStatus(Admin admin) {
        loginMapper.setAdminStatus(admin);
    }

}
