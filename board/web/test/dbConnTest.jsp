<%@ page import="java.sql.Connection" %>
<%@ page import="jdbc.ConnectionProvider" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-12-17
  Time: 오전 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>연결 테스트</title>
</head>
<body>
<%
    try(Connection conn = ConnectionProvider.getConnection()){
        out.println("커넥션 연결 성공");
    }catch (SQLException e){
        out.println("커넥션 연결 실패 " + e.getMessage());
    }
%>
</body>
</html>
