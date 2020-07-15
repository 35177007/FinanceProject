package com.project.service.impl;

import com.project.mapper.LogoutMapper;
import com.project.service.LogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogoutServiceImpl implements LogoutService {
    @Autowired
    private LogoutMapper logoutMapper;

    @Override
    public int logoutUser(Integer id) {
        return logoutMapper.logoutUser(id);
    }

    @Override
    public int logoutAdmin(Integer id) {
        return logoutMapper.logoutAdmin(id);
    }
}
