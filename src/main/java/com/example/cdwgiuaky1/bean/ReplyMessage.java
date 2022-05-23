package com.example.cdwgiuaky1.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReplyMessage extends AMessage {

    public ReplyMessage(Long id, String title, Calendar createdTime, String content, User creator) {
        super(id, title, createdTime, content, creator);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getCreatedTime() {
        return createdTime;
    }

    public String getFormatCreatedTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm a");
        return sdf.format(this.createdTime.getTime());
    }

    public void setCreatedTime(Calendar createdTime) {
        this.createdTime = createdTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
