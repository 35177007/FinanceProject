package com.project.pojo;

import java.util.Date;

public class Loan {
    private Integer id;
    private Integer loanId;
    private Integer examineId;
    private Date loanTime;
    private Double amount;
    private Integer term;
    private Double rate;
    private Integer applyStatus;
    private Integer loanStatus;
    private String username;
    private String reputation;

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", loanId=" + loanId +
                ", examineId=" + examineId +
                ", loanTime=" + loanTime +
                ", amount=" + amount +
                ", term=" + term +
                ", rate=" + rate +
                ", applyStatus=" + applyStatus +
                ", loanStatus=" + loanStatus +
                ", username='" + username + '\'' +
                ", reputation='" + reputation + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public Integer getExamineId() {
        return examineId;
    }

    public void setExamineId(Integer examineId) {
        this.examineId = examineId;
    }

    public Date getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double  amount) {
        this.amount = amount;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Integer getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(Integer loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public Loan(Integer loanId, Integer examineId, Date loanTime, Double amount, Integer term, Double rate, Integer applyStatus, Integer loanStatus, String username, String reputation) {

        this.loanId = loanId;
        this.examineId = examineId;
        this.loanTime = loanTime;
        this.amount = amount;
        this.term = term;
        this.rate = rate;
        this.applyStatus = applyStatus;
        this.loanStatus = loanStatus;
        this.username = username;
        this.reputation = reputation;
    }

    public Loan() {
    }
}
