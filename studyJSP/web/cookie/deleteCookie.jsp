<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-27
  Time: 오후 1:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.URLEncoder" %>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0) {
        for(int i=0;i<cookies.length;i++){
            // 쿠키의 이름이 name인게 존재하면
            if(cookies[i].getName().equals("name")){
                Cookie cookie = new Cookie("name","");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }
%>
<html>
<head>
    <title>쿠키 삭제</title>
</head>
<body>
name 쿠키 삭제.
</body>
</html>
