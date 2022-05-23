package com.example.cdwgiuaky1;

import com.example.cdwgiuaky1.services.ForumData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CdwGiuaKy1Application {

    public static void main(String[] args) {
        SpringApplication.run(CdwGiuaKy1Application.class, args);
    }

    @PostConstruct
    private void init() {
        //generate init value
        ForumData forumData = new ForumData();
    }

}
