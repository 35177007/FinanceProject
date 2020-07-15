package com.project.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class UserPayInfo {
    private Integer id;
    private Integer userId;
    private Integer payId;
    private Date startTime;
    private BigDecimal averYield;
    private BigDecimal profit;
    private Integer status;

    public UserPayInfo(Integer id, Integer userId, Integer payId, Date startTime, BigDecimal averYield, BigDecimal profit, Integer status) {
        this.id = id;
        this.userId = userId;
        this.payId = payId;
        this.startTime = startTime;
        this.averYield = averYield;
        this.profit = profit;
        this.status = status;
    }

    public UserPayInfo() {
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

    public BigDecimal getAverYield() {
        return averYield;
    }

    public void setAverYield(BigDecimal averYield) {
        this.averYield = averYield;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserPayInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", payId=" + payId +
                ", startTime=" + startTime +
                ", averYield=" + averYield +
                ", profit=" + profit +
                ", status=" + status +
                '}';
    }
}
