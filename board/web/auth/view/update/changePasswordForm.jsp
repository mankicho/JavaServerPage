<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-12-21
  Time: 오후 3:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>비밀번호 변경하기</title>
</head>
<body>
<form action="/changePassword.do" method="post">
    <p>현재 비밀번호 : <input type="text" name="curPassword"/><br>
        <c:if test="${errors.curPassword}">현재 암호를 입력하세요</c:if>
    </p>
    <p>변경하고싶은 비밀번호 : <input type="text" name="newPassword"/><br>
        <c:if test="${errors.newPassword}">변경할 비밀번호를 입력하세요.</c:if>
    </p>
    <input type="submit" value="변경하기"/>
</form>
</body>
</html>
