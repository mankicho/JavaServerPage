<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-23
  Time: 오후 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<%
    String id = request.getParameter("name");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    System.out.println(id);
    if (id.equals("조만기")) {
        response.sendRedirect("response.jsp");
    } else {
        response.sendRedirect("loginFail.jsp");
    }
%>
</body>
</html>
cd