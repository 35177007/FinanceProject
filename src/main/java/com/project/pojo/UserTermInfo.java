package com.project.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class UserTermInfo {
    private Integer id;
    private Integer userId;
    private Integer termId;
    private Date startTime;
    private BigDecimal averYield;
    private BigDecimal profit;
    private Integer status;

    public UserTermInfo(Integer id, Integer userId, Integer termId, Date startTime, BigDecimal averYield, BigDecimal profit, Integer status) {
        this.id = id;
        this.userId = userId;
        this.termId = termId;
        this.startTime = startTime;
        this.averYield = averYield;
        this.profit = profit;
        this.status = status;
    }

    public UserTermInfo() {
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
        return termId;
    }

    public void setPayId(Integer termId) {
        this.termId = termId;
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
        return "UserTermInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", termId=" + termId +
                ", startTime=" + startTime +
                ", averYield=" + averYield +
                ", profit=" + profit +
                ", status=" + status +
                '}';
    }
}
