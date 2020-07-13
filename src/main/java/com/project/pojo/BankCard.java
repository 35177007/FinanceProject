package com.project.pojo;

public class BankCard {
    private Integer id;
    private String cardBank;
    private Integer type;
    private String cardNum;
    private String username;
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardBank() {
        return cardBank;
    }

    public void setCardBank(String cardBank) {
        this.cardBank = cardBank;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BankCard(Integer id, String cardBank, Integer type, String cardNum, String username, Integer userId) {
        this.id = id;
        this.cardBank = cardBank;
        this.type = type;
        this.cardNum = cardNum;
        this.username = username;
        this.userId = userId;
    }

    public BankCard() {
    }
}
