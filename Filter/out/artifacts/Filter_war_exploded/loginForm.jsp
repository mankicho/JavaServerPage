<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-12-16
  Time: 오후 8:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 화면</title>
</head>
<body>
로그인 해주세요. ( filter를 거쳐서 확인해봤더니 session 에 member 객체가 없는 경우 ) <br>
<form action="/login.do" method="post">
    아이디 : <input type="text" name="id" size="10"/> <br>
    비밀번호 : <input type="text" name="pw" size="10"/>
    <input type="submit" value="로그인"/>
</form>
</body>
</html>
