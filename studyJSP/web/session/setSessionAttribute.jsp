<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-28
  Time: 오후 5:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>세션 속성 생성</title>
</head>
<body>
<%
    session.setAttribute("name","조만기");
    session.setAttribute("value","만기만기");
%>

세션을 추가했습니다. 추가한 세션은
<%=session.getAttribute("name")%> 이랑 <%=session.getAttribute("value")%>
</body>
</html>
