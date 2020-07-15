package com.project.mapper;

import com.project.pojo.Loan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface LoanMapper {
    public List<Loan> selectLoanAll();
    public int passApplyStatus(Loan loan);
    public int notPassapplyStatus(Loan loan);
    public List<Loan> selectLoanById(Integer id);
    public int repayLoan(Integer id);
}
