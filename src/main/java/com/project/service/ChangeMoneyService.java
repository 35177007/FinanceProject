package com.project.service;

import com.project.pojo.ChangeMoney;

import java.util.List;

public interface ChangeMoneyService {
    public List<ChangeMoney> selectChangeMoneyAll();
    public int addChangeMoney(ChangeMoney changeMoney);
    public ChangeMoney selectChangeMoneyById(Integer id);

    public int updateChangeMoney(ChangeMoney changeMoney);

    public int deleteChangeMoney(Integer id);

}
