<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Show Topic</title>
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
    <div class="topic" style="margin-top: 15px">
        <div class="topicTitle">
            <div style="display: flex;justify-content: space-between">
                <p style="font-weight: bold;padding-top: 8px;font-size: 20px">Chủ đề: ${topic.getTitle()}</p>
                <c:if test="${sessionScope.user != null}">
                    <a href="/replyTopic?idTopic=${topic.getId()}&forumTitle=${forumTitle}">Trả lời</a>
                </c:if>
            </div>
            <p>Bài viết gửi ${topic.getFormatCreatedTime()}, do ${topic.getCreator().getUserName()}
                gửi, ${topic.getListReplyMessages().size()} hồi âm</p>
            <p>Nội dung: ${topic.getContent()}</p>
        </div>
        <div style="margin-top: 20px">
            <c:forEach var="replyMessage" items="${topic.getReverseList()}">
                <div class="main" style="margin-top: 5px">
                    <table style="width: 100%">
                        <tr>
                            <td colspan="2">
                                    ${replyMessage.getFormatCreatedTime()}
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 20%">
                                <p>${replyMessage.getCreator().getUserName()}</p>
                                <p>Tham gia ${replyMessage.getCreator().getJoinDate()}</p>
                            </td>
                            <td style="width: 80%">
                                <table style="width: 100%">
                                    <tr>
                                        <td style="width: 100%;border: none">${replyMessage.getTitle()}</td>
                                    </tr>
                                    <tr>
                                        <td style="width: 100%;border: none;border-top: 1px solid black">${replyMessage.getContent()}</td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </div>
            </c:forEach>
        </div>
    </div>
    <div style="text-align: right">
        <a href="/listTopics">Danh sách chủ đề</a>
    </div>
</div>
</body>
</html>