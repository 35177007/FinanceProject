package com.project.service;

import com.project.pojo.Info;

import java.util.List;

public interface LoanInfoService {
    public List<com.project.pojo.LoanInfo> selectLoanInfoAll();
    public int insertLoadInfo(Info info);
}
