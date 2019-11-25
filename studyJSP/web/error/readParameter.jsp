<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-25
  Time: 오후 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="viewErrorMessage.jsp" %>
<html>
<head>
    <title>파라미터 출력</title>
</head>
<body>
에러페이지를 지정해주었다. <br>
name 파라미터 값 : <%=request.getParameter("name").toUpperCase()%>
</body>
</html>
