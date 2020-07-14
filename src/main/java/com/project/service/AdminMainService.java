package com.project.service;

import com.project.pojo.User;

import java.util.List;

public interface AdminMainService {
    public List<User> selectUserAll();

    public int goOffline(Integer id);
}
