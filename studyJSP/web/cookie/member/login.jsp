<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-27
  Time: 오후 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="util.Cookies" %>
<%
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    String password = request.getParameter("password");

    if(id.equals(password)){
        response.addCookie(Cookies.createCookie("AUTH",id,"/",-1));
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
로그인에 성공하셨습니다.
</body>
</html>
