package com.project.service;

import com.project.pojo.FlowOfFunds;
import com.project.pojo.TermFinancial;
import com.project.pojo.UserTermInfo;

import java.util.List;

public interface UserTermServce {
    public List<TermFinancial> selectUserTermAll();

    public TermFinancial selectUserTermById(Integer id);

    public int insertUserTerm(UserTermInfo userTermInfo);

    public int insertFlowOfFund(FlowOfFunds flowOfFunds);
}
