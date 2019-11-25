<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-25
  Time: 오후 1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>파라미터 출력</title>
</head>
<body>
name 파라미터 값 : <%=request.getParameter("name").toUpperCase()%>
name 파라미터가없는데 출력해서 HTTP status 500 에러가 떴다.
</body>
</html>
