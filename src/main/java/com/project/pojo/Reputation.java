package com.project.pojo;

public class Reputation {

    private Integer id;
    private String username;
    private String reputation;

    public Reputation(Integer id, String username, String reputation) {
        this.id = id;
        this.username = username;
        this.reputation = reputation;
    }

    public Reputation() {
    }

    @Override
    public String toString() {
        return "Reputation{" +
                "id=" + id +
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
}
