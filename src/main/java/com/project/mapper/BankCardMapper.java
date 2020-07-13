package com.project.mapper;

import com.project.pojo.BankCard;
import com.project.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BankCardMapper {
    public List<BankCard> selectBankCardAll();

//
//
    public BankCard selectBankCardById(Integer id);
//
//
    public int updateBankCard(BankCard bankCard);
//
//
    public int deleteBankCard(Integer id);
}
