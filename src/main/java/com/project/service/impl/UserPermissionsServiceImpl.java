package com.project.service.impl;

import com.project.mapper.UserPermissionsMapper;
import com.project.pojo.UserPermissions;
import com.project.service.UserPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserPermissionsServiceImpl implements UserPermissionsService {

    @Autowired
    private UserPermissionsMapper userPermissionsMapper;

    @Override
    public List<UserPermissions> selectUserPermissionsById(Integer integer) {
        return userPermissionsMapper.selectUserPermissionsById(integer);
    }

    @Override
    public Integer selectPermissionIdWithUser(String string) {
        return userPermissionsMapper.selectPermissionIdWithUser(string);
    }

    @Override
    public void deleteUserPermissionsAll(Integer integer) {
        userPermissionsMapper.deleteUserPermissionsAll(integer);
    }

    @Override
    public int insertUserPermissions(UserPermissions userPermissions) {
        return userPermissionsMapper.insertUserPermissions(userPermissions);
    }
}
