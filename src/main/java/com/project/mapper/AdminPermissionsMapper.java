package com.project.mapper;

import com.project.pojo.AdminPermissions;
import com.project.pojo.Permissions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminPermissionsMapper {
    public List<AdminPermissions> selectAdminPermissionsById(Integer integer);
    //更新操作
    public Integer selectPermissionId(String string);

    public void deleteAdminPermissionsAll(Integer integer);


    public int insertAdminPermissions(AdminPermissions adminPermissions);
}
