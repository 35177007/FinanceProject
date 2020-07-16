package com.project.pojo;

public class AdminPermissions {
    private Integer id;
    private Integer adminId;
    private String permission;
    private  Integer permissionId;
    public AdminPermissions(){}


    public AdminPermissions(Integer id, Integer adminId, String permission, Integer permissionId) {
        this.id = id;
        this.adminId = adminId;
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

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "AdminPermissions{" +
                "id=" + id +
                ", adminId=" + adminId +
                ", permission='" + permission + '\'' +
                ", permissionId=" + permissionId +
                '}';
    }
}
