<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-28
  Time: 오후 6:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 화면</title>
</head>
<body>
<form action="sessionLogin.jsp" method="post">
    아이디 : <input type="text" name="id" size="10"/>
    비밀번호 : <input type="text" name="password" size="10"/>
    <input type="submit" value="로그인"/>
</form>
</body>
</html>
