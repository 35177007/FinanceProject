package com.project.mapper;

import com.project.pojo.Info;
import com.project.pojo.LoanInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface LoanInfoMapper {
    public List<LoanInfo> selectLoanInfoAll();
    public int insertLoadInfo(Info info);
}
