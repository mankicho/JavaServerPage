<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-28
  Time: 오후 5:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>세션 종료</title>
</head>
<body>
<%
    session.invalidate();
%>
세션을 삭제했습니다. <br>
세션을 삭제하고나면 다른 페이지가 실행시 새로 세션이 만들어진다.
</body>
</html>
