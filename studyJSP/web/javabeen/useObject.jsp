<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-27
  Time: 오전 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="member" scope="request" class="javabeen.member.MemberInfo"/>
<html>
<head>
    <title>인사 말</title>
</head>
<body>
<%=member.getName()%> (<%=member.getId()%>) 회원님 <br>
안녕하세요.
</body>
</html>
