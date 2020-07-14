package com.project.pojo;

import java.math.BigDecimal;

public class PayMoney {
    private Integer id;
    private BigDecimal monthMoney;
    private Integer autoInto;
    private Integer type;
    private String invesTerm;
    public PayMoney(){}

    public PayMoney(Integer id, BigDecimal monthMoney, Integer autoInto, Integer type, String invesTerm) {
        this.id = id;
        this.monthMoney = monthMoney;
        this.autoInto = autoInto;
        this.type = type;
        this.invesTerm = invesTerm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMonthMoney() {
        return monthMoney;
    }

    public void setMonthMoney(BigDecimal monthMoney) {
        this.monthMoney = monthMoney;
    }

    public Integer getAutoInto() {
        return autoInto;
    }

    public void setAutoInto(Integer autoInto) {
        this.autoInto = autoInto;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getInvesTerm() {
        return invesTerm;
    }

    public void setInvesTerm(String invesTerm) {
        this.invesTerm = invesTerm;
    }

    @Override
    public String toString() {
        return "PayMoney{" +
                "id=" + id +
                ", monthMoney=" + monthMoney +
                ", autoInto=" + autoInto +
                ", type=" + type +
                ", invesTerm='" + invesTerm + '\'' +
                '}';
    }
}
