<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %><%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-27
  Time: 오후 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie cookie = new Cookie("name", URLEncoder.encode("조만기", StandardCharsets.UTF_8));
    Cookie cookie2 = new Cookie("kimchi", URLEncoder.encode("김치찌개", StandardCharsets.UTF_8));
    response.addCookie(cookie);
    response.addCookie(cookie2);
%>
<html>
<head>
    <title>쿠키 생성</title>
</head>
<body>
<%=cookie.getName()%> 쿠키의 값 <%=cookie.getValue()%>
</body>
</html>
