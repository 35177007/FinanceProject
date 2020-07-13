package com.project.service.impl;

import com.project.mapper.BankCardMapper;
import com.project.pojo.BankCard;
import com.project.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BankCardServiceImpl implements BankCardService {
    @Autowired
    private  BankCardMapper bankCardMapper;
    @Override
    public List<BankCard> selectBankCardAll() {
        return bankCardMapper.selectBankCardAll();
    }

    @Override
    public int deleteBankCard(Integer id) {
        return bankCardMapper.deleteBankCard(id);
    }

    @Override
    public BankCard selectBankCardById(Integer id) {
        return bankCardMapper.selectBankCardById(id);
    }

    @Override
    public int updateBankCard(BankCard bankCard) {
        return bankCardMapper.updateBankCard(bankCard);
    }
}
