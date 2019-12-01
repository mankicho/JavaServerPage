<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-29
  Time: 오전 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>테이블 레코드 삽입하기</title>
</head>
<body>
<form action="insert.jsp" method="post">
    아이디 <input type="text" name="id"><br>
    이름 <input type="text" name="name"><br>
    나이 <input type="text" name="age"><br>
    <input type="submit" value="삽입하기">
</form>
</body>
</html>
