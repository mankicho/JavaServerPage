<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-27
  Time: 오후 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0) {
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("name")) {
                // 쿠키의 값을 변경하기위해 새로운 쿠키 생성후 응답에 추가.
                Cookie cookie = new Cookie("name", URLEncoder.encode("JSP 프로그래밍", StandardCharsets.UTF_8));
                response.addCookie(cookie);
            }
        }
    }
%>
<html>
<head>
    <title>쿠키 값 변경</title>
</head>
<body>
쿠키의 값을 변경합니다.
</body>
</html>
