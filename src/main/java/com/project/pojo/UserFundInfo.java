package com.project.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class UserFundInfo {
    private Integer id;
    private Integer userId;
    private Integer fundId;
    private Date startTime;
    private BigDecimal averYield;
    private BigDecimal profit;
    private Integer status;

    public UserFundInfo(Integer id, Integer userId, Integer fundId, Date startTime, BigDecimal averYield, BigDecimal profit, Integer status) {
        this.id = id;
        this.userId = userId;
        this.fundId = fundId;
        this.startTime = startTime;
        this.averYield = averYield;
        this.profit = profit;
        this.status = status;
    }

    public UserFundInfo() {
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
        return "UserFundInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", fundId=" + fundId +
                ", startTime=" + startTime +
                ", averYield=" + averYield +
                ", profit=" + profit +
                ", status=" + status +
                '}';
    }
}
