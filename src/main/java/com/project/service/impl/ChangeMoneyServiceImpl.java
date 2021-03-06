package com.project.service.impl;

import com.project.mapper.ChangeMoneyMapper;
import com.project.pojo.ChangeMoney;
import com.project.service.ChangeMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChangeMoneyServiceImpl implements ChangeMoneyService {
    @Autowired
    private ChangeMoneyMapper changeMoneyMapper;

    @Override
    public List<ChangeMoney> selectChangeMoneyAll() {
        return changeMoneyMapper.selectChangeMoneyAll();
    }

    @Override
    public int addChangeMoney(ChangeMoney changeMoney) {
        return changeMoneyMapper.addChangeMoney(changeMoney);
    }


    @Override
    public ChangeMoney selectChangeMoneyById(Integer id) {
        return changeMoneyMapper.selectChangeMoneyById(id);
    }

    @Override
    public int updateChangeMoney(ChangeMoney changeMoney) {
        return changeMoneyMapper.updateChangeMoney(changeMoney);
    }

    @Override
    public int deleteChangeMoney(Integer id) {
        return changeMoneyMapper.deleteChangeMoney(id);
    }
}
