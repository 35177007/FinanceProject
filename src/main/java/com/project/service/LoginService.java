package com.project.service;

import com.project.pojo.Admin;
import com.project.pojo.User;

public interface LoginService {

    public Admin selectAdminByUserName(String username);
    public User selectUserByUserName(String username);
    public Admin adminLogin(Admin admin);
    public User userLogin(User user);
    public void setUserStatus(User user);
    public void setAdminStatus(Admin admin);
}
