package com.project.pojo;

import java.util.Date;

public class Info {
    private Integer id;
    private Integer sendId;
    private Integer receiveId;
    private String title;
    private Date createTime;
    private String infoDesc;
    private Integer status;

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", sendId=" + sendId +
                ", receiveId=" + receiveId +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
                ", infoDesc='" + infoDesc + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public Integer getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getInfoDesc() {
        return infoDesc;
    }

    public void setInfoDesc(String infoDesc) {
        this.infoDesc = infoDesc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Info(Integer sendId, Integer receiveId, String title, Date createTime, String infoDesc, Integer status) {

        this.sendId = sendId;
        this.receiveId = receiveId;
        this.title = title;
        this.createTime = createTime;
        this.infoDesc = infoDesc;
        this.status = status;
    }

    public Info() {
    }
}
