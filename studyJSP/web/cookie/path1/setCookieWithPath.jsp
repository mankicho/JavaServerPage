<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-27
  Time: 오후 1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%
    Cookie cookie1 = new Cookie("path1", URLEncoder.encode("경로:/cookie/path1", StandardCharsets.UTF_8));
    cookie1.setPath("/cookie/path1");
    response.addCookie(cookie1);

    Cookie cookie2 = new Cookie("path2", URLEncoder.encode("경로:/cookie.path2", StandardCharsets.UTF_8));
    cookie2.setPath("/cookie/path2");
    response.addCookie(cookie2);

    Cookie cookie3 = new Cookie("path3", URLEncoder.encode("경로:/", StandardCharsets.UTF_8));
    cookie3.setPath("/");
    response.addCookie(cookie3);
%>
<html>
<head>
    <title>쿠키 경로 설정</title>
</head>
<body>
쿠키를 생성했습니다. <br>
<%=cookie1.getName()%> = <%=cookie1.getValue()%>
[<%=cookie1.getPath()%>
<br>
<%=cookie2.getName()%> = <%=cookie2.getValue()%> [<%=cookie2.getPath()%>
<br>
<%=cookie3.getName()%> = <%=cookie3.getValue()%> [<%=cookie3.getPath()%>
</body>
</html>
