<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-27
  Time: 오후 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<html>
<head>
    <title>쿠키 목록</title>
</head>
<body>
<%
    // 웹 브라우저는 request에 쿠키정보를 같이 담아서 보내기때문에 request.getCookies 매서드를 이용해 쿠키정보에 접근 가능하다.
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0) {
        for (int i = 0; i < cookies.length; i++) {
            out.println(cookies[i].getName() + " = " + URLDecoder.decode(cookies[i].getValue(), StandardCharsets.UTF_8)+"\n");
            out.println();
        }
    }else{
        out.println("쿠키가 존재하지 않습니다.");
    }
%>
</body>
</html>
