package com.project.pojo;

import java.util.Date;

public class UserShowChange {
    private Integer id;
    private Integer userId;
    private Integer changeId;
    private Date startTime;
    private Double averYield;
    private Double profit;
    private Integer status;
    private String name;
    private Double invesMoney;
    private String invesTerm;

    @Override
    public String toString() {
        return "UserShowChange{" +
                "id=" + id +
                ", userId=" + userId +
                ", changeId=" + changeId +
                ", startTime=" + startTime +
                ", averYield=" + averYield +
                ", profit=" + profit +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", invesMoney=" + invesMoney +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getInvesMoney() {
        return invesMoney;
    }

    public void setInvesMoney(Double invesMoney) {
        this.invesMoney = invesMoney;
    }

    public String getInvesTerm() {
        return invesTerm;
    }

    public void setInvesTerm(String invesTerm) {
        this.invesTerm = invesTerm;
    }

    public UserShowChange(Integer id, Integer userId, Integer changeId, Date startTime, Double averYield, Double profit, Integer status, String name, Double invesMoney, String invesTerm) {
        this.id = id;
        this.userId = userId;
        this.changeId = changeId;
        this.startTime = startTime;
        this.averYield = averYield;
        this.profit = profit;
        this.status = status;
        this.name = name;
        this.invesMoney = invesMoney;
        this.invesTerm = invesTerm;
    }

    public UserShowChange() {
    }
}
