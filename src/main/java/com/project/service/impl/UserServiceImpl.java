package com.project.service.impl;

import com.project.mapper.UserMapper;
import com.project.pojo.User;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserAll() {
        return userMapper.selectUserAll();
    }
    @Override
    public int addUser(User user){
        return userMapper.addUser(user);
    }

    @Override
    public User selectUserByTerms(String username) {
        return userMapper.selectUserByTerms(username);
    }


    @Override
    public User selectUserById(Integer id){
        return userMapper.selectUserById(id);
    }


    @Override
    public int updateUser(User user){
        return userMapper.updateUser(user);
    }

    @Override
    public int setPwd(User user) {
        return userMapper.setPwd(user);
    }

    @Override
    public int updateUserById(User user) {
        return userMapper.updateUserById(user);
    }


    @Override
    public int deleteUser(Integer id){
        return userMapper.deleteUser(id);
    }
}
