package com.project.service.impl;

import com.project.mapper.UserApplyLoanMapper;
import com.project.pojo.Loan;
import com.project.service.UserApplyLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApplyLoanServiceImpl implements UserApplyLoanService {
    @Autowired
    private UserApplyLoanMapper userApplyLoanMapper;

    @Override
    public int applyLoan(Loan loan) {
        return userApplyLoanMapper.applyLoan(loan);
    }
}
