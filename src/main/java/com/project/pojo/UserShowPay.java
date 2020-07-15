package com.project.pojo;

import java.util.Date;

public class UserShowPay {
    private Integer id;
    private Integer userId;
    private Integer payId;
    private Date startTime;
    private Double averYield;
    private Double profit;
    private Integer status;
    private Double monthMoney;
    private Integer type;
    private String invesTerm;

    @Override
    public String toString() {
        return "UserShowPay{" +
                "id=" + id +
                ", userId=" + userId +
                ", payId=" + payId +
                ", startTime=" + startTime +
                ", averYield=" + averYield +
                ", profit=" + profit +
                ", status=" + status +
                ", monthMoney=" + monthMoney +
                ", type=" + type +
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

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
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

    public Double getMonthMoney() {
        return monthMoney;
    }

    public void setMonthMoney(Double monthMoney) {
        this.monthMoney = monthMoney;
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

    public UserShowPay(Integer id, Integer userId, Integer payId, Date startTime, Double averYield, Double profit, Integer status, Double monthMoney, Integer type, String invesTerm) {
        this.id = id;
        this.userId = userId;
        this.payId = payId;
        this.startTime = startTime;
        this.averYield = averYield;
        this.profit = profit;
        this.status = status;
        this.monthMoney = monthMoney;
        this.type = type;
        this.invesTerm = invesTerm;
    }

    public UserShowPay() {
    }
}
