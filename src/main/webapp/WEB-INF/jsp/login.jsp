<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>

    <style>
        body {
            margin: 0;
            padding: 0;
        }

        p {
            margin: 0;
        }

        .container {
            position: fixed;
            left: 50%;
            -webkit-transform: translate(-50%, 0%);
            transform: translate(-50%, 0%);
        }
    </style>
</head>
<body>
<div class="container" style="border: 1px solid black;width: 350px">
    <div class="header" style="border-bottom: 1px solid black;background-color: aqua">
        <p style="text-align: center;padding-top:5px;padding-bottom:5px;font-size: 20px;font-weight: bold">Đăng nhập</p>
    </div>
    <div class="body">
        <table style="margin-bottom: 20px">
            <form action="/login" method="post">
                <tr>
                    <td>Tên Đăng Nhập</td>
                    <td><input type="text" name="userName" required></td>
                </tr>
                <tr>
                    <td style="text-align: right">Mật khẩu</td>
                    <td><input type="text" name="password" required></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <button type="submit">Đăng nhập</button>
                    </td>
                </tr>
                <c:if test="${errorMessage != null}">
                    <tr>
                        <td style="color: red;text-align: right">Lỗi :</td>
                        <td style="color: red">Sai tên hoặc mật khẩu</td>
                    </tr>
                </c:if>
            </form>
        </table>
    </div>
</div>
</body>
</html>