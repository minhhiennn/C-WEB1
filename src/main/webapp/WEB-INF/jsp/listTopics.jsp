<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List Topic</title>
    <style>
        .container {
            padding-right: 15px;
            padding-left: 15px;
            margin-right: auto;
            margin-left: auto;
            width: 800px;
        }

        p {
            padding: 0;
            margin: 0;
        }

        th, td {
            border: 1px solid silver;
        }

        thead tr th {
            background-color: darkgray;
        }

        .main {
            overflow: auto;
            height: 200px;
        }

        .main thead th {
            position: sticky;
            top: 0;
            z-index: 1;
        }

    </style>
</head>
<body>
<div class="container">
    <c:if test="${sessionScope.user != null}">
        <div class="header" style="text-align: right">
            <span>Chào ${sessionScope.user.getUserName()} | </span>
            <a href="/logout">Thoát</a>
        </div>
    </c:if>
    <c:forEach var="forum" items="${listForums}">
        <div class="topic">
            <div class="topicTitle">
                <p style="font-weight: bold;padding-top: 8px;font-size: 20px">Diễn đàn: ${forum.getTitle()}</p>
            </div>
            <c:if test="${sessionScope.user != null}">
                <div class="" style="margin-top: 15px">
                    <button onclick="window.location.href='/newTopic?forumTitle=${forum.getTitle()}'">Gửi bài mới
                    </button>
                </div>
            </c:if>
            <div class="main" style="margin-top: 20px">
                <table style="width: 100%">
                    <thead>
                    <tr>
                        <th style="width: 75%">Chủ đề</th>
                        <th style="width: 25%">Hồi âm</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="topic" items="${forum.getListTopic()}">
                        <tr>
                            <td>
                                <div>
                                    <a href="/showTopic?topicId=${topic.id}&forumTitle=${forum.getTitle()}">${topic.title}</a>
                                    <p>Bài viết by <a
                                            href="#">${topic.creator.getUserName()}</a>, ${topic.getFormatCreatedTime()}
                                    </p>
                                </div>
                            </td>
                            <td style="text-align: center">${topic.getListReplyMessages().size()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>