<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-27
  Time: 오후 2:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="util.Cookies" %>
<%
    response.addCookie(Cookies.createCookie("AUTH",",","/",0));
%>
<html>
<head>
    <title>로그아웃 처리</title>
</head>
<body>
로그아웃하였습니다.
</body>
</html>
