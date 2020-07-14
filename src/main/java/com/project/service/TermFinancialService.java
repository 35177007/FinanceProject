package com.project.service;

import com.project.pojo.TermFinancial;

import java.util.List;

public interface TermFinancialService {
    public List<TermFinancial> selectTermFinancialAll();

    public int addTermFinancial(TermFinancial termFinancial);

    public TermFinancial selectTermFinancialById(Integer id);

    public int updateTermFinancial(TermFinancial termFinancial );

    public int deleteTermFinancial(Integer id);
}
