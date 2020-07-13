package com.project.service;

import com.project.pojo.BankCard;

import java.util.List;

public interface BankCardService {
    public List<BankCard> selectBankCardAll();
    public int deleteBankCard(Integer id);
    public BankCard selectBankCardById(Integer id);
    public int updateBankCard(BankCard bankCard);
}
