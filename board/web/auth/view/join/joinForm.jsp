<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-12-17
  Time: 오후 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<form action="join.do" method="post">
    <p> 아이디: <input type="text" name="id"/> <br>
        <c:if test="${errors.id}">ID를 입력하세요</c:if>
        <c:if test="${errors.duplicateId}">이미 존재하는 아이디 입니다.</c:if>
    </p>
    <p> 이름 : <input type="text" name="name"/><br>
        <c:if test="${errors.name}">이름을 입력하세요</c:if>
    </p>
    <p>암호 : <input type="text" name="password"/><br>
        <c:if test="${errors.password}">암호를 입력하세요</c:if>
    </p>
    <p>암호 확인 : <input type="text" name="confirmPassword"/><br>
        <c:if test="${errors.confirmPassword}">확인을 입력하세요</c:if>
        <c:if test="${errors.notMatch}">암호와 확인이 일치하지 않습니다.</c:if>
    </p>
    <input type="submit" value="가입"/>
</form>
</body>
</html>
