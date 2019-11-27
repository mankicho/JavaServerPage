<%@ page import="util.Cookies" %><%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-27
  Time: 오후 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookies cookies = new Cookies(request);
    if (cookies.exists("AUTH")) {
        out.println("아이디 = " + cookies.getValue("AUTH"));
    } else {
        // 쿠키가 존재하는지 확인하고 아니면 로그인 상태가 아닌것.
        out.println("로그인 상태가 아닙니다.");
    }
%>

<html>
<head>
    <title>로그인 여부 검사</title>
</head>
<body>

</body>
</html>
