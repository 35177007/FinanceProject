package com.project.mapper;

import com.project.pojo.Bank;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BankMapper {
    public List<Bank> selectBankAll();

    public int addBank(Bank bank);


    public Bank selectBankById(Integer id);


    public int updateBank(Bank bank);


    public int deleteBank(Integer id);
}
