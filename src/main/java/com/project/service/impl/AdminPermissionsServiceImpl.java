package com.project.service.impl;

import com.project.mapper.AdminPermissionsMapper;
import com.project.pojo.AdminPermissions;
import com.project.pojo.Permissions;
import com.project.service.AdminPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminPermissionsServiceImpl implements AdminPermissionsService {

    @Autowired
    private AdminPermissionsMapper adminPermissionsMapper;

    @Override
    public List<AdminPermissions> selectAdminPermissionsById(Integer integer) {
        return adminPermissionsMapper.selectAdminPermissionsById(integer);
    }

    @Override
    public Integer selectPermissionId(String string) {
        return adminPermissionsMapper.selectPermissionId(string);
    }

    @Override
    public void deleteAdminPermissionsAll(Integer integer) {
        adminPermissionsMapper.deleteAdminPermissionsAll(integer);

    }

    @Override
    public int insertAdminPermissions(AdminPermissions adminPermissions) {
        return adminPermissionsMapper.insertAdminPermissions(adminPermissions);
    }
}
