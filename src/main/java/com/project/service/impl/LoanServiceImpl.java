package com.project.service.impl;

import com.project.mapper.LoanMapper;
import com.project.pojo.Loan;
import com.project.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanMapper loanMapper;
    @Override
    public List<Loan> selectLoanAll() {
        return loanMapper.selectLoanAll();
    }

    @Override
    public int passApplyStatus(Loan loan) {
        return loanMapper.passApplyStatus(loan);
    }

    @Override
    public int notPassapplyStatus(Loan loan) {
        return loanMapper.notPassapplyStatus(loan);
    }
}
