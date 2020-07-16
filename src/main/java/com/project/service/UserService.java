package com.project.service;

import com.project.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> selectUserAll();

    public int addUser(User user);
    public User selectUserByTerms(String username);

    public User selectUserById(Integer id);


    public int updateUser(User user);
    public int updateUserById(User user);
    public int setPwd(User user);
    public int deleteUser(Integer id);
}
