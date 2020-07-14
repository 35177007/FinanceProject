package com.project.pojo;

import java.util.Date;

public class News{
    private Integer id;
    private String title;
    private String newsdesc;
    private Date createtime;

    public News() {
    }

    public News(Integer id, String title, String newsdesc, Date createtime) {
        this.id = id;
        this.title = title;
        this.newsdesc = newsdesc;
        this.createtime = createtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsdesc() {
        return newsdesc;
    }

    public void setNewsdesc(String newsdesc) {
        this.newsdesc = newsdesc;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", newsdesc='" + newsdesc + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
