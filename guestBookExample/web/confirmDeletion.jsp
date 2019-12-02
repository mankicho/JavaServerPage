<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-12-02
  Time: 오전 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>방명록 삭제하기</title>
</head>
<body>
메세지를 삭제하시려면 비밀번호를 입력해주세요. <br>
<form action="deleteMessage.jsp" method="post">
    <input type="hidden" name="messageId" value="${param.messageId}"/>
    비밀번호 : <input type="text" name="password"/><br>
    <input type="submit" value="삭제하기"/>
</form>
</body>
</html>
