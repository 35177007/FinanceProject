package com.project.mapper;

import com.project.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> selectUserAll();

    public int addUser(User user);


    public User selectUserById(Integer id);


    public int updateUser(User user);
    public int updateUserById(User user);

    public int setPwd(User user);
    public int deleteUser(Integer id);
}
