package com.project.service.impl;

import com.project.mapper.ReputationMapper;
import com.project.pojo.Reputation;
import com.project.pojo.User;
import com.project.service.ReputationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReputationServiceImpl implements ReputationService {
    @Autowired
    private ReputationMapper reputationMapper;
    public List<Reputation> selectReputationAll() {
        return reputationMapper.selectReputationAll();
    }

    public Reputation selectReputationById(Integer id){
        return reputationMapper.selectReputationById(id);
    }


    public int updateReputation(Reputation reputation){
        return reputationMapper.updateReputation(reputation);
    }
}
