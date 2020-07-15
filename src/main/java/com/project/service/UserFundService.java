package com.project.service;

import com.project.pojo.FlowOfFunds;
import com.project.pojo.FundProduct;
import com.project.pojo.UserFundInfo;

import java.util.List;

public interface UserFundService {
    public List<FundProduct> selectUserFundAll();

    public FundProduct selectUserFundById(Integer id);

    public int insertUserFund(UserFundInfo userFundInfo);

    public int insertFlowOfFund(FlowOfFunds flowOfFunds);
}
