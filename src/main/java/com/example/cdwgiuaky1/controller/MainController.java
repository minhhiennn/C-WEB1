package com.example.cdwgiuaky1.controller;

import com.example.cdwgiuaky1.bean.*;
import com.example.cdwgiuaky1.services.ForumData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;

@Controller
public class MainController {

    @GetMapping({""})
    public String homePage() {
        return "redirect:/listTopics";
    }


    @GetMapping("/listTopics")
    public String listTopicsPage(HttpServletRequest request, Model model) {
        model.addAttribute("listForums", ForumData.getInstance().getForums());
        return "listTopics";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }

    @GetMapping("/newTopic")
    public String newTopicPage(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        String forumTitle = request.getParameter("forumTitle");
        model.addAttribute("title", forumTitle);
        return "newTopic";
    }

    @PostMapping("/newTopic")
    public String addNewTopic(HttpServletRequest request) {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String forumTitle = request.getParameter("forumTitle");
        User user = (User) request.getSession().getAttribute("user");
        Topic topic = new Topic(ForumData.getInstance().countAllTopic() + 1, title, Calendar.getInstance(), content, user);
        Forum forum = ForumData.getInstance().getForumWithTitle(forumTitle);
        forum.addTopic(topic);
        return "redirect:/listTopics";
    }

    @GetMapping("/replyTopic")
    public String replyTopicPage(HttpServletRequest request, @RequestParam("idTopic") String idTopic, @RequestParam("forumTitle") String forumTitle, Model model) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        Topic topic = ForumData.getInstance().getTopicById(Long.parseLong(idTopic));
        model.addAttribute("topic", topic);
        model.addAttribute("forumTitle", forumTitle);
        return "replyTopic";
    }

    @PostMapping("/replyTopic")
    public String replyTopic(HttpServletRequest request) throws UnsupportedEncodingException {
        String idTopic = request.getParameter("idTopic");
        String forumTitle = request.getParameter("forumTitle");
        System.out.println(forumTitle);
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        User user = (User) request.getSession().getAttribute("user");
        AMessage replyMessage = new ReplyMessage(ForumData.getInstance().countAllTopic() + 1, title, Calendar.getInstance(), content, user);
        Topic topic = ForumData.getInstance().getTopicById(Long.parseLong(idTopic));
        topic.getListReplyMessages().add(replyMessage);
        String encodedForumTitle = URLEncoder.encode(forumTitle, "UTF-8");
        return "redirect:/showTopic?topicId=" + idTopic + "&forumTitle=" + encodedForumTitle;
    }

    @GetMapping("/showTopic")
    public String showTopicPage(HttpServletRequest request, Model model) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        String topicId = request.getParameter("topicId");
        String forumTitle = request.getParameter("forumTitle");
        System.out.println(forumTitle);
        Forum forum = ForumData.getInstance().getForumWithTitle(forumTitle);
        Topic topic = forum.getTopicById(Long.parseLong(topicId));
        System.out.println(topic.getCreator().getUserName());
        model.addAttribute("topic", topic);
        model.addAttribute("forumTitle", forumTitle);
        return "showTopic";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String checkUser(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpServletRequest request, Model model) {
        User user = ForumData.getInstance().checkUser(userName, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            return "redirect:/listTopics";
        }
        model.addAttribute("errorMessage", "loi vc");
        return "login";
    }
}
