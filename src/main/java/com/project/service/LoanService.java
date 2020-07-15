package com.project.service;

import com.project.pojo.Loan;

import java.util.List;

public interface LoanService {
    public List<Loan> selectLoanAll();
    public int passApplyStatus(Loan loan);
    public int notPassapplyStatus(Loan loan);
    public List<Loan> selectLoanById(Integer id);
    public int repayLoan(Integer id);
}
