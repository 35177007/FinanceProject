package com.project.mapper;

import com.project.pojo.FlowOfFunds;
import com.project.pojo.PayMoney;
import com.project.pojo.UserPayInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserPayMapper {
    public List<PayMoney> selectUserPayAll();

    public PayMoney selectUserPayById(Integer id);

    public int insertUserPay(UserPayInfo userPayInfo);

    public int insertFlowOfFund(FlowOfFunds flowOfFunds);
}
