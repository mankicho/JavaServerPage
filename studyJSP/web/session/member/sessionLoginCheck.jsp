<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-28
  Time: 오후 6:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String memberId = (String) session.getAttribute("MemberId");
    boolean login = memberId != null;
%>
<html>
<head>
    <title>로그인 여부 검사</title>
</head>
<body>
<%
    if (login) {
        out.println("로그인 한 상태, 아이디 : " + memberId);
    }else{
        out.print("로그인 하지 않은 상태");
    }
%>
</body>
</html>
