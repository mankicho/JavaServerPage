<%@ page import="guestbook.service.WriteMessageService" %><%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-12-02
  Time: 오전 8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="message" class="guestbook.model.Message">
    <jsp:setProperty name="message" property="name" param="name"/>
    <jsp:setProperty name="message" property="password" param="password"/>
    <jsp:setProperty name="message" property="message" param="message"/>
</jsp:useBean>
<%
    WriteMessageService writeService = WriteMessageService.getInstance();
    writeService.write(message);
%>
<html>
<head>
    <title>방명록 메세지 남김</title>
</head>
<body>
방명록에 메세지를 남겼습니다. <br>
<a href="list.jsp">[목록 보기]</a>
</body>
</html>
