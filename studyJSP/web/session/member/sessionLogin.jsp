<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-28
  Time: 오후 6:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    String password = request.getParameter("password");

    if(id.equals(password)){
        session.setAttribute("MemberId",id);
    }
%>
<html>
<head>
    <title>로그인 성공</title>
</head>
<body>
로그인에 성공하셨습니다.
</body>
</html>
