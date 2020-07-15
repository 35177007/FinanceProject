package com.project.mapper;

import com.project.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserInfoMapper {
    public List<UserInfo> selectUserInfo(Integer id);
    public int updateInfo(Integer id);
    public int userDeleteInfo(Integer id);
}
