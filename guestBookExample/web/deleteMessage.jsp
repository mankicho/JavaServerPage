<%@ page import="guestbook.service.DeleteMessageService" %>
<%@ page import="guestbook.exception.InvalidPasswordException" %><%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-12-02
  Time: 오전 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String password = request.getParameter("password");
    int messageId = Integer.parseInt(request.getParameter("messageId"));
    boolean invalidPassword = false;
    try {
        DeleteMessageService deleteService = DeleteMessageService.getInstance();
        deleteService.deleteMessage(messageId, password);
    } catch (InvalidPasswordException e) {
        invalidPassword = true;
    }
%>
<html>
<head>
    <title></title>
</head>
<body>
<%
    if (invalidPassword){
        out.println("비밀번호가 틀렸습니다. 다시 입력해주세요");
    }else{
        out.println("메세지가 삭제되었습니다.");
    }
%>
<a href="list.jsp">메세지 목록보기</a>
</body>
</html>
