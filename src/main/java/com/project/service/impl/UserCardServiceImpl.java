package com.project.service.impl;

import com.project.mapper.UserCardMapper;
import com.project.pojo.BankCard;
import com.project.pojo.User;
import com.project.service.UserCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserCardServiceImpl implements UserCardService {

    @Autowired
    public UserCardMapper userCardMapper;

    @Override
    public List<BankCard> selectCardAll(Integer id) {
        return userCardMapper.selectCardAll(id);
    }

    @Override
    public int addCard(BankCard bankCard) {
        return userCardMapper.addCard(bankCard);
    }

    @Override
    public BankCard selectCardById(Integer id) {
        return userCardMapper.selectCardById(id);
    }

    @Override
    public int updateCard(BankCard bankCard) {
        return userCardMapper.updateCard(bankCard);
    }

    @Override
    public int deleteCardById(Integer id) {
        return userCardMapper.deleteCardById(id);
    }
}
