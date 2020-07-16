package com.project.service;

import com.project.pojo.Admin;
import com.project.pojo.User;

import java.util.List;

public interface AdminMainService {
    public List<User> selectUserAll();
    public Admin selectAdminByTerms(String username);
    public int goOffline(Integer id);
}
