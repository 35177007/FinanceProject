package com.project.mapper;

import com.project.pojo.Admin;
import com.project.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AdminMainMapper {


    public List<User> selectUserAll();
    public Admin selectAdminByTerms(String username);
    public int goOffline(Integer id);
}
