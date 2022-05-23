<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reply topic</title>
    <style>
        .container {
            padding-right: 15px;
            padding-left: 15px;
            margin-right: auto;
            margin-left: auto;
            width: 500px;
        }

        p {
            padding: 0;
            margin: 0;
        }

        textarea {
            overflow-y: scroll;
            height: 100px;
            resize: none; /* Remove this if you want the user to resize the textarea */
        }


    </style>
</head>
<body>
<div class="container">
    <div class="header" style="text-align: right">
        <span>Chào ${sessionScope.user.getUserName()} | </span>
        <a href="/logout">Thoát</a>
    </div>
    <div style="width: 100%">
        <form id="form" action="/replyTopic" method="post">
            <input name="idTopic" style="display: none" value="${topic.getId()}">
            <input name="forumTitle" style="display: none" value="${forumTitle}">
            <h3>Tiêu đề</h3>
            <input name="title" style="width: 70%" type="text">

            <h3>Nội dung</h3>
            <textarea name="content" style="width: 100%"></textarea>
        </form>


        <div style="margin-top: 10px">
            <button onclick="document.getElementById('form').submit()">Gởi</button>
            <button onclick="window.location.href='/listTopics'">Hủy bỏ</button>
        </div>
    </div>
</div>
</body>
</html>