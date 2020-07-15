package com.project.service.impl;

import com.project.mapper.LoanInfoMapper;
import com.project.pojo.Info;
import com.project.pojo.LoanInfo;
import com.project.service.LoanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoanInfoServiceImpl implements LoanInfoService {
    @Autowired
    private LoanInfoMapper loanInfoMapper;
    @Override
    public List<LoanInfo> selectLoanInfoAll() {
        return loanInfoMapper.selectLoanInfoAll();
    }

    @Override
    public int insertLoadInfo(Info info) {
        return loanInfoMapper.insertLoadInfo(info);
    }


}
