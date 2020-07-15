package com.project.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class UserChangeInfo {
    private Integer id;
    private Integer userId;
    private Integer changeId;
    private Date startTime;
    private BigDecimal averYield;
    private BigDecimal profit;
    private Integer status;

    public UserChangeInfo(Integer id, Integer userId, Integer changeId, Date startTime, BigDecimal averYield, BigDecimal profit, Integer status) {
        this.id = id;
        this.userId = userId;
        this.changeId = changeId;
        this.startTime = startTime;
        this.averYield = averYield;
        this.profit = profit;
        this.status = status;
    }

    public UserChangeInfo() {
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

    public Integer getChangeId() {
        return changeId;
    }

    public void setChangeId(Integer changeId) {
        this.changeId = changeId;
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
        return "UserChangeInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", changeId=" + changeId +
                ", startTime=" + startTime +
                ", averYield=" + averYield +
                ", profit=" + profit +
                ", status=" + status +
                '}';
    }
}
