package com.project.pojo;

import java.util.Date;

public class UserShowTerm {
    private Integer id;
    private Integer userId;
    private Integer termId;
    private Date startTime;
    private Double averYield;
    private Double profit;
    private Integer status;
    private String name;
    private Double leastMoney;
    private String invesTerm;

    @Override
    public String toString() {
        return "UserShowTerm{" +
                "id=" + id +
                ", userId=" + userId +
                ", termId=" + termId +
                ", startTime=" + startTime +
                ", averYield=" + averYield +
                ", profit=" + profit +
                ", status=" + status +
                ", name='" + name + '\'' +
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

    public Integer getTermId() {
        return termId;
    }

    public void setTermId(Integer termId) {
        this.termId = termId;
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

    public UserShowTerm(Integer id, Integer userId, Integer termId, Date startTime, Double averYield, Double profit, Integer status, String name, Double leastMoney, String invesTerm) {
        this.id = id;
        this.userId = userId;
        this.termId = termId;
        this.startTime = startTime;
        this.averYield = averYield;
        this.profit = profit;
        this.status = status;
        this.name = name;
        this.leastMoney = leastMoney;
        this.invesTerm = invesTerm;
    }

    public UserShowTerm() {
    }
}
