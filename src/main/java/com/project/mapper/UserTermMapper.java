package com.project.mapper;

import com.project.pojo.TermFinancial;
import com.project.pojo.FlowOfFunds;
import com.project.pojo.UserTermInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserTermMapper {
    public List<TermFinancial> selectUserTermAll();

    public TermFinancial selectUserTermById(Integer id);

    public int insertUserTerm(UserTermInfo userTermInfo);

    public int insertFlowOfFund(FlowOfFunds flowOfFunds);
}
