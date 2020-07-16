package com.project.mapper;

import com.project.pojo.UserShowChange;
import com.project.pojo.UserShowFund;
import com.project.pojo.UserShowPay;
import com.project.pojo.UserShowTerm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserShowFinanceMapper {
    public List<UserShowFund> selectUserFund(Integer id);
    public List<UserShowChange> selectUserChange(Integer id);
    public List<UserShowPay> selectUserPay(Integer id);
    public List<UserShowTerm> selectUserTerm(Integer id);
    public int removeUserPay(Integer id);
    public int removeUserTerm(Integer id);
    public int removeUserChange(Integer id);
    public int removeUserFund(Integer id);
}
