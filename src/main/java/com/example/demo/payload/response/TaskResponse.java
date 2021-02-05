package com.example.demo.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TaskResponse {
    private String name;
    private String describe;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    private Date achievedDate;
    private boolean status;

    public TaskResponse(String name, String describe, Date createDate, Date achievedDate, boolean status) {
        this.name = name;
        this.describe = describe;
        this.createDate = createDate;
        this.achievedDate = achievedDate;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getAchievedDate() {
        return achievedDate;
    }

    public void setAchievedDate(Date achievedDate) {
        this.achievedDate = achievedDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
