<%@ page import="guestbook.service.GetMessageListService" %>
<%@ page import="guestbook.service.MessageListView" %>
<%@ page import="guestbook.model.Message" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-12-01
  Time: 오후 5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String pageNumberStr = request.getParameter("page");
    int pageNumber = 1;
    if (pageNumberStr != null) {
        pageNumber = Integer.parseInt(pageNumberStr);
    }

    GetMessageListService messageListService = GetMessageListService.getInstance();
    MessageListView view = messageListService.getMessageList(pageNumber);
    List<Message> messageList = view.getMessageList();
%>
<html>
<head>
    <title>방명록 메세지 목록</title>
</head>
<body>
<form action="writeMessage.jsp" method="post">
    이름 : <input type="text" name="name"><br>
    암호 : <input type="text" name="password"><br>
    메세지 : <br>
    <textarea name="message" cols="30" rows="3"></textarea><br>
    <input type="submit" value="메세지 남기기"/>
</form>
<%
    if (view.isEmpty()) {
        out.println("등록된 메세지가 없습니다.");
    } else {
        for (Message message : messageList) {
%>
<table border="1">
    <tr>
        <td>메세지 번호 : <%=message.getId()%><br>
            손님 이름 : <%=message.getName()%><br>
            메세지 : <%=message.getMessage()%><br>
            <a href="confirmDeletion.jsp?messageId=<%=message.getId()%>"/>삭제하기</a></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
