package com.project.pojo;

public class UserPermissions {
    private Integer id;
    private Integer userId;
    private String permission;
    private Integer permissionId;

    public UserPermissions() {
    }

    public UserPermissions(Integer id, Integer userId, String permission, Integer permissionId) {
        this.id = id;
        this.userId = userId;
        this.permission = permission;
        this.permissionId = permissionId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "UserPermissions{" +
                "id=" + id +
                ", userId=" + userId +
                ", permission='" + permission + '\'' +
                ", permissionId=" + permissionId +
                '}';
    }
}
