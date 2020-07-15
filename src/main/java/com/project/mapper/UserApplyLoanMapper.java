package com.project.mapper;

import com.project.pojo.Loan;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserApplyLoanMapper {
    public int applyLoan(Loan loan);
}
