<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-28
  Time: 오후 5:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
    Date time = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<html>
<head>
    <title>세션 정보</title>
</head>
<body>
세션ID = <%=session.getId()%> <br>
<%
    time.setTime(session.getCreationTime());
%>
세션 생성시간 : <%=format.format(time)%> <br>
<%
    time.setTime(session.getLastAccessedTime());
%>
최근 접근시간 : <%=format.format(time)%> <br>

<%=session.getAttribute("name")%>
</body>
</html>
