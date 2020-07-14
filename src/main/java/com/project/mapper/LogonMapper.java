package com.project.mapper;

import com.project.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogonMapper {
    public int logonInsert(User user);
}
