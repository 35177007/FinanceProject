package com.project.mapper;


import com.project.pojo.PayMoney;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PayMoneyMapper {

    public List<PayMoney> selectPayMoneyAll();

    public int addPayMoney(PayMoney payMoney);

    public PayMoney selectPayMoneyById(Integer id);

    public int updatePayMoney(PayMoney payMoney);

    public int deletePayMoney(Integer id);
}
