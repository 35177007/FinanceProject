package com.project.mapper;

import com.project.pojo.FlowOfFunds;
import com.project.pojo.FundProduct;
import com.project.pojo.UserFundInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserFundMapper {
    public List<FundProduct> selectUserFundAll();

    public FundProduct selectUserFundById(Integer id);

    public int insertUserFund(UserFundInfo userFundInfo);

    public int insertFlowOfFund(FlowOfFunds flowOfFunds);
}
