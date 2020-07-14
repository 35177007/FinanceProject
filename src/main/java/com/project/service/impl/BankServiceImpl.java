package com.project.service.impl;

import com.project.mapper.BankMapper;
import com.project.pojo.Bank;

import com.project.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankMapper bankMapper;

    @Override
    public List<Bank> selectBankAll() {
        return bankMapper.selectBankAll();
    }
    public int addBank(Bank bank){
        return bankMapper.addBank(bank);
    }


    public Bank selectBankById(Integer id){
        return bankMapper.selectBankById(id);
    }


    public int updateBank(Bank bank){
        return bankMapper.updateBank(bank);
    }


    public int deleteBank(Integer id){
        return bankMapper.deleteBank(id);
    }
}
