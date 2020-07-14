package com.project.service;

import com.project.pojo.Bank;

import java.util.List;

public interface BankService {
    public List<Bank> selectBankAll();

    public int addBank(Bank bank);


    public Bank selectBankById(Integer id);


    public int updateBank(Bank bank);


    public int deleteBank(Integer id);
}
