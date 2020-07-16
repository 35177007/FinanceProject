package com.project.mapper;

import com.project.pojo.Bank;
import com.project.pojo.BankCard;
import com.project.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserCardMapper {
    public List<BankCard> selectCardAll(Integer id);
    public int addCard(BankCard bankCard);
    public BankCard selectCardById(Integer id);
    public int updateCard(BankCard bankCard);
    public int deleteCardById(Integer id);
}
