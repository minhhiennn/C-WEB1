package com.example.cdwgiuaky1.bean;

import java.text.SimpleDateFormat;
import java.util.*;

public class Topic extends AMessage {
    private List<AMessage> listReplyMessages = new ArrayList<>();

    public Topic(Long id, String title, Calendar createdTime, String content, User creator) {
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

//    public AMessage getNewMessage() {
//        return null;
//    }

    public List<AMessage> getListReplyMessages() {
        return this.listReplyMessages;
    }

    public void addReplyMessage(AMessage replyMessage) {
        this.listReplyMessages.add(replyMessage);
    }

    public List<AMessage> getReverseList() {
        final List<AMessage> result = new ArrayList<>(this.getListReplyMessages());
        Collections.reverse(result);
        return result;
    }
}
