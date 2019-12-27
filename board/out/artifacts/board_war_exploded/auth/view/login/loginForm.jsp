<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-12-19
  Time: 오후 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<form action="login.do" method="post">
    <c:if test="${errors.idOrPasswordNotMatch}">아이디 또는 암호가 일치하지 않습니다.</c:if>
    <p>아이디 : <input type="text" name="id"/>
        <c:if test="${errors.id}">아이디를 입력하세요.</c:if>
    </p>
    <p>비밀번호 : <input type="text" name="password"/>
        <c:if test="${errors.password}">비밀번호를 입력하세요</c:if>
    </p>

    <input type="submit" value="로그인"/>
</form>
</body>
</html>
