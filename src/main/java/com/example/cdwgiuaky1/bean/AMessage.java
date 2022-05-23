package com.example.cdwgiuaky1.bean;

import java.util.Calendar;

public class AMessage {
    protected Long id;
    protected String title;
    protected Calendar createdTime;
    protected String content;
    protected User creator;

    public AMessage(Long id,String title,Calendar createdTime,String content,User creator) {
        this.id = id;
        this.title = title;
        this.createdTime = createdTime;
        this.content = content;
        this.creator = creator;
    }

}
