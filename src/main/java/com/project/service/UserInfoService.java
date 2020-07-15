package com.project.service;

import com.project.pojo.UserInfo;

import java.util.List;

public interface UserInfoService {
    public List<UserInfo> selectUserInfo(Integer id);
    public int updateInfo(Integer id);
    public int userDeleteInfo(Integer id);
}
