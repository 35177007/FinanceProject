package com.project.service;

import com.project.pojo.UserPermissions;

import java.util.List;

public interface UserPermissionsService {
    public List<UserPermissions> selectUserPermissionsById(Integer integer);

    public Integer selectPermissionIdWithUser(String string);

    public void deleteUserPermissionsAll(Integer integer);


    public int insertUserPermissions(UserPermissions userPermissions);
}
