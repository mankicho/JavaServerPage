<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-12-17
  Time: 오전 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>웹 어플리케이션 초기화면</title>
</head>
<body>
<c:if test="${empty authUser}">
    <a href="join.do">회원가입 하기</a> <br>
    <a href="login.do">로그인 하기</a>
</c:if>
<c:if test="${!empty authUser}">
    <a href="logout.do">로그아웃 하기</a><br>
    <a href="changePassword.do">암호 변경하기</a>
</c:if>

</body>
</html>
