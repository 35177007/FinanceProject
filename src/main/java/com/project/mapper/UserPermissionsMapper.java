package com.project.mapper;

import com.project.pojo.UserPermissions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserPermissionsMapper {
    public List<UserPermissions> selectUserPermissionsById(Integer integer);

    public Integer selectPermissionIdWithUser(String string);

    public void deleteUserPermissionsAll(Integer integer);


    public int insertUserPermissions(UserPermissions userPermissions);
}
