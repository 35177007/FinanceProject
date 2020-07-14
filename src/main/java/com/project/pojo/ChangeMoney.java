package com.project.pojo;

import java.math.BigDecimal;

public class ChangeMoney {
    private Integer id;
    private String name;
    private BigDecimal annualIncome;
    private BigDecimal peiIncome;
    private String invesTerm;
    private BigDecimal invesMoney;
    public ChangeMoney(){}

    public ChangeMoney(Integer id, String name, BigDecimal annualIncome, BigDecimal peiIncome, String invesTerm, BigDecimal invesMoney) {
        this.id = id;
        this.name = name;
        this.annualIncome = annualIncome;
        this.peiIncome = peiIncome;
        this.invesTerm = invesTerm;
        this.invesMoney = invesMoney;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(BigDecimal annualIncome) {
        this.annualIncome = annualIncome;
    }

    public BigDecimal getPeiIncome() {
        return peiIncome;
    }

    public void setPeiIncome(BigDecimal peiIncome) {
        this.peiIncome = peiIncome;
    }

    public String getInvesTerm() {
        return invesTerm;
    }

    public void setInvesTerm(String invesTerm) {
        this.invesTerm = invesTerm;
    }

    public BigDecimal getInvesMoney() {
        return invesMoney;
    }

    public void setInvesMoney(BigDecimal invesMoney) {
        this.invesMoney = invesMoney;
    }

    @Override
    public String toString() {
        return "ChangeMoney{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", annualIncome=" + annualIncome +
                ", peiIncome=" + peiIncome +
                ", invesTerm='" + invesTerm + '\'' +
                ", invesMoney=" + invesMoney +
                '}';
    }
}
