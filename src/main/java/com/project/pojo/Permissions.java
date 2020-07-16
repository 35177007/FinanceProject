package com.project.pojo;

public class Permissions {
    private Integer id;
    private String permission;

    public Permissions() {
    }

    public Permissions(Integer id, String permission) {
        this.id = id;
        this.permission = permission;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                '}';
    }
}
