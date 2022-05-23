package com.example.cdwgiuaky1.bean;

import java.util.ArrayList;
import java.util.List;

public class Forum {
    private String title;
    //    private final List<Forum> subForums = new ArrayList<>();
    private final List<Topic> topicList = new ArrayList<>();

    public Forum(String title) {
        this.title = title;
    }

    public void addTopic(Topic topic) {
        this.topicList.add(topic);
    }

    public Topic getTopicById(Long topicId) {
        for (Topic topic : topicList) {
            if (topic.getId() == topicId) {
                return topic;
            }
        }
        return null;
    }

    public List<Topic> getListTopic() {
        return this.topicList;
    }

    public String getTitle() {
        return this.title;
    }

}
