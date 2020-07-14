package com.project.pojo;

public class Bank {

    private Integer id;
    private String name;
    private String type;
    private String assets;
    private String bankDesc;

    public Bank() {
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", assets='" + assets + '\'' +
                ", bankDesc='" + bankDesc + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAssets() {
        return assets;
    }

    public void setAssets(String assets) {
        this.assets = assets;
    }

    public String getBankDesc() {
        return bankDesc;
    }

    public void setBankDesc(String bankDesc) {
        this.bankDesc = bankDesc;
    }

    public Bank(Integer id, String name, String type, String assets, String bankDesc) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.assets = assets;
        this.bankDesc = bankDesc;
    }
}
