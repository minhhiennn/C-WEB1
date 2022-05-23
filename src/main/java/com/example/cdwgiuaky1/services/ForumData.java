package com.example.cdwgiuaky1.services;

import com.example.cdwgiuaky1.bean.*;

import java.util.*;


public class ForumData {
    private Map<String, User> users = new HashMap<>();
    private List<Forum> forums = new ArrayList<>();
    private static ForumData instance;

    public ForumData() {
        instance = this;
        //
        this.users = new HashMap<>();
        this.forums = new ArrayList<>();
        //init user data
        User user1 = new User("chuotcon", "chuotcon", "chuotcon@gmail.com", new Date());
        User user2 = new User("chuotcon2", "chuotcon2", "chuotcon2@gmail.com", new Date());
        User user3 = new User("chuotcon3", "chuotcon3", "chuotcon3@gmail.com", new Date());
        User user4 = new User("chuotcon4", "chuotcon4", "chuotcon4@gmail.com", new Date());
        this.users.put("1", user1);
        this.users.put("2", user2);
        this.users.put("3", user3);
        this.users.put("4", user4);
        //init forum data
        Forum forum1 = new Forum("Chuyện học phí và các chính sách hỗ trợ học tập");
        Forum forum2 = new Forum("Chuyện sàm sí đú");
        this.forums.add(forum1);
        this.forums.add(forum2);
    }

    public static ForumData getInstance() {
        return instance;
    }

    public List<Forum> getForums() {
        return this.forums;
    }

    public Forum getForumWithTitle(String title) {
        for (Forum forum : forums) {
            if (forum.getTitle().equals(title)) {
                return forum;
            }
        }
        return null;
    }

    public Topic getTopicById(Long id) {
        for (Forum forum : forums) {
            for (Topic topic : forum.getListTopic()) {
                if (topic.getId() == id) {
                    return topic;
                }
            }
        }
        return null;
    }

    public long countAllTopic() {
        long count = 0;
        for (Forum forum : forums) {
            for (Topic topic : forum.getListTopic()) {
                count++;
                for (AMessage replyMessage : topic.getListReplyMessages()) {
                    count++;
                }
            }
        }
        return count;
    }

    public User checkUser(String name, String password) {
        for (Map.Entry<String, User> entry : users.entrySet()) {
            User user = entry.getValue();
            if (user.getUserName().equals(name) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
