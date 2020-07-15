package com.project.mapper;

import com.project.pojo.UserMoneyHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMoneyHistoryMapper {
    public List<UserMoneyHistory> selectUserMoneyHistory(Integer id);
}
