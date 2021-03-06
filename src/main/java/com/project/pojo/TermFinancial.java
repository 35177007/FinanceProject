package com.project.pojo;

import java.math.BigDecimal;

public class TermFinancial {
    private Integer id;
    private String name;
    private String invesTerm;
    private BigDecimal leastMoney;
    private Integer profit;
    private BigDecimal annualIncome;
    public TermFinancial(){}

    public TermFinancial(Integer id, String name, String invesTerm, BigDecimal leastMoney, Integer profit, BigDecimal annualIncome) {
        this.id = id;
        this.name = name;
        this.invesTerm = invesTerm;
        this.leastMoney = leastMoney;
        this.profit = profit;
        this.annualIncome = annualIncome;
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

    public String getInvesTerm() {
        return invesTerm;
    }

    public void setInvesTerm(String invesTerm) {
        this.invesTerm = invesTerm;
    }

    public BigDecimal getLeastMoney() {
        return leastMoney;
    }

    public void setLeastMoney(BigDecimal leastMoney) {
        this.leastMoney = leastMoney;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public BigDecimal getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(BigDecimal annualIncome) {
        this.annualIncome = annualIncome;
    }

    @Override
    public String toString() {
        return "TermFinancial{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", invesTerm='" + invesTerm + '\'' +
                ", leastMoney=" + leastMoney +
                ", profit=" + profit +
                ", annualIncome=" + annualIncome +
                '}';
    }
}
