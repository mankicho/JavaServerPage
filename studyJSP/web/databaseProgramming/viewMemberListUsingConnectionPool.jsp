<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-12-01
  Time: 오후 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 목록 보기</title>
</head>
<body>
<table width="200" border="1">
    <tr>
        <td>ID</td>
        <td>이름</td>
        <td>나이</td>
    </tr>
    <%
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            String jdbcDriver = "jdbc:apache:commons:dbcp:jsp";
            String query = "select * from jsp.member";
            conn = DriverManager.getConnection(jdbcDriver);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
    %>
    <tr>
        <td><%=rs.getString("id")%>
        </td>
        <td><%=rs.getString("name")%>
        </td>
        <td><%=rs.getInt("age")%>
        </td>
    </tr>
    <%
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    %>
</table>
</body>
</html>