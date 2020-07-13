package com.project.mapper;

import com.project.pojo.Reputation;
import com.project.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ReputationMapper {
    public List<Reputation> selectReputationAll();

    public Reputation selectReputationById(Integer id);
    public int updateReputation(Reputation reputation);
}
