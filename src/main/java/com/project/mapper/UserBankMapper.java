package com.project.mapper;

import com.project.pojo.Bank;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserBankMapper {
    public List<Bank> selectBankAll();
}
