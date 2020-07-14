package com.project.mapper;


import com.project.pojo.ChangeMoney;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChangeMoneyMapper {
    public List<ChangeMoney> selectChangeMoneyAll();

    public int addChangeMoney(ChangeMoney changeMoney);
}
