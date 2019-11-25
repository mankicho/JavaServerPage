<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-25
  Time: 오후 1:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>에러 발생</title>
</head>
<body>
Page의 isErrorPage 속성을 true로 설정해주면 에러페이지로 지정이되고 에러 발생시 에러페이지로 지정된 JSP페이지가 출력이 된다.<br>
에러 타입 : <%=exception.getClass().getName()%> <br>
에러페이지로 지정되면 JSP의 기본객체인 exception 객체를 사용할 수 있다. <br>
에러 메세지 : <%=exception.getMessage()%>
</body>
</html>
