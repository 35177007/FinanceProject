package com.project.mapper;

import org.apache.ibatis.annotations.Mapper;

    @Mapper
    public interface LogoutMapper {
        public int logoutUser(Integer id);
        public int logoutAdmin(Integer id);
}
