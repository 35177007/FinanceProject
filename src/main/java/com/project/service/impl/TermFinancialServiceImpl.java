package com.project.service.impl;

import com.project.mapper.TermFinancialMapper;
import com.project.pojo.TermFinancial;
import com.project.service.TermFinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermFinancialServiceImpl implements TermFinancialService {
    @Autowired
    private TermFinancialMapper termFinancialMapper;

    @Override
    public List<TermFinancial> selectTermFinancialAll() {
        return termFinancialMapper.selectTermFinancialAll();
    }

    @Override
    public int addTermFinancial(TermFinancial termFinancial) {
        return termFinancialMapper.addTermFinancial(termFinancial);
    }

    @Override
    public TermFinancial selectTermFinancialById(Integer id) {
        return termFinancialMapper.selectTermFinancialById(id);
    }

    @Override
    public int updateTermFinancial(TermFinancial termFinancial) {
        return termFinancialMapper.updateTermFinancial(termFinancial);
    }

    @Override
    public int deleteTermFinancial(Integer id) {
        return termFinancialMapper.deleteTermFinancial(id);
    }
}
