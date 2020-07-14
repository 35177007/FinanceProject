package com.project.mapper;


import com.project.pojo.TermFinancial;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TermFinancialMapper {
    public List<TermFinancial> selectTermFinancialAll();

    public int addTermFinancial(TermFinancial termFinancial);

    public TermFinancial selectTermFinancialById(Integer id);

    public int updateTermFinancial(TermFinancial termFinancial );

    public int deleteTermFinancial(Integer id);
}
