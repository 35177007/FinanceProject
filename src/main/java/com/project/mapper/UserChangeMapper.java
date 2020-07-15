package com.project.mapper;

import com.project.pojo.ChangeMoney;
import com.project.pojo.FlowOfFunds;
import com.project.pojo.UserChangeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserChangeMapper {

    public List<ChangeMoney> selectUserChangeAll();

    public ChangeMoney selectUserChangeById(Integer id);

    public int insertUserChange(UserChangeInfo userChangeInfo);

    public int insertFlowOfFund(FlowOfFunds flowOfFunds);
}
