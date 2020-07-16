package com.project.service;

import com.project.pojo.AdminPermissions;
import com.project.pojo.Permissions;

import java.util.List;

public interface AdminPermissionsService {
    public List<AdminPermissions> selectAdminPermissionsById(Integer integer);


    public Integer selectPermissionId(String string);

    public void deleteAdminPermissionsAll(Integer integer);


    public int insertAdminPermissions(AdminPermissions adminPermissions);
}
