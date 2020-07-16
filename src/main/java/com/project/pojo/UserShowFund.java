package com.project.pojo;

import java.util.Date;

public class UserShowFund {
    private Integer id;
    private Integer userId;
    private Integer fundId;
    private Date startTime;
    private Double averYield;
    private Double profit;
    private Integer status;
    private String fundDesc;
    private Double dailyGrowth;
    private Double leastMoney;
    private String invesTerm;

    @Override
    public String toString() {
        return "UserShowFund{" +
                "id=" + id +
                ", userId=" + userId +
                ", fundId=" + fundId +
                ", startTime=" + startTime +
                ", averYield=" + averYield +
                ", profit=" + profit +
                ", status=" + status +
                ", fundDesc='" + fundDesc + '\'' +
                ", dailyGrowth=" + dailyGrowth +
                ", leastMoney=" + leastMoney +
                ", invesTerm='" + invesTerm + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Double getAverYield() {
        return averYield;
    }

    public void setAverYield(Double averYield) {
        this.averYield = averYield;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFundDesc() {
        return fundDesc;
    }

    public void setFundDesc(String fundDesc) {
        this.fundDesc = fundDesc;
    }

    public Double getDailyGrowth() {
        return dailyGrowth;
    }

    public void setDailyGrowth(Double dailyGrowth) {
        this.dailyGrowth = dailyGrowth;
    }

    public Double getLeastMoney() {
        return leastMoney;
    }

    public void setLeastMoney(Double leastMoney) {
        this.leastMoney = leastMoney;
    }

    public String getInvesTerm() {
        return invesTerm;
    }

    public void setInvesTerm(String invesTerm) {
        this.invesTerm = invesTerm;
    }

    public UserShowFund(Integer id, Integer userId, Integer fundId, Date startTime, Double averYield, Double profit, Integer status, String fundDesc, Double dailyGrowth, Double leastMoney, String invesTerm) {
        this.id = id;
        this.userId = userId;
        this.fundId = fundId;
        this.startTime = startTime;
        this.averYield = averYield;
        this.profit = profit;
        this.status = status;
        this.fundDesc = fundDesc;
        this.dailyGrowth = dailyGrowth;
        this.leastMoney = leastMoney;
        this.invesTerm = invesTerm;
    }

    public UserShowFund() {
    }
}
