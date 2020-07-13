package com.project.service;

import com.project.pojo.Reputation;
import com.project.pojo.User;

import java.util.List;

public interface ReputationService {

    public List<Reputation> selectReputationAll();

    public Reputation selectReputationById(Integer id);

    public int updateReputation(Reputation reputation);
}
