package com.project.service.impl;

import com.project.mapper.LogonMapper;
import com.project.pojo.User;
import com.project.service.LogonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogonServiceImpl implements LogonService {
    @Autowired
    private LogonMapper logonMapper;
    @Override
    public int logonInsert(User user) {
        return logonMapper.logonInsert(user);
    }
}
