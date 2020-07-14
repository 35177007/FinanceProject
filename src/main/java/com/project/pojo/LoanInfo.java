package com.project.pojo;

public class LoanInfo {
    private Integer id;
    private String username;
    private String realname;
    private String password;
    private String IDcard;
    private String phone;
    private String email;
    private Float amount;
    private Integer term;
    private Integer loanStatus;

    @Override
    public String toString() {
        return "LoadInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", IDcard='" + IDcard + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", amount=" + amount +
                ", term=" + term +
                ", loanStatus=" + loanStatus +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(Integer loanStatus) {
        this.loanStatus = loanStatus;
    }

    public LoanInfo(Integer id, String username, String realname, String password, String IDcard, String phone, String email, Float amount, Integer term, Integer loanStatus) {
        this.id = id;
        this.username = username;
        this.realname = realname;
        this.password = password;
        this.IDcard = IDcard;
        this.phone = phone;
        this.email = email;
        this.amount = amount;
        this.term = term;
        this.loanStatus = loanStatus;
    }

    public LoanInfo() {
    }
}
