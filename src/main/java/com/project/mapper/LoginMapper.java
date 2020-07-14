package com.project.mapper;

import com.project.pojo.Admin;
import com.project.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    public Admin selectAdminByUserName(String username);
    public User selectUserByUserName(String username);
    public Admin adminLogin(Admin admin);
    public User userLogin(User user);
    public void setUserStatus(User user);
    public void setAdminStatus(Admin admin);

}
