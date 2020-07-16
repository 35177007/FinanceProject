package com.project.service;

import com.project.pojo.BankCard;
import com.project.pojo.User;

import java.util.List;

public interface UserCardService {
    public List<BankCard> selectCardAll(Integer id);
    public int addCard(BankCard bankCard);
    public BankCard selectCardById(Integer id);
    public int updateCard(BankCard bankCard);
    public int deleteCardById(Integer id);
}
