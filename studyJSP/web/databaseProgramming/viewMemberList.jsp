<%@ page import="com.mysql.cj.protocol.Resultset" %>
<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-29
  Time: 오전 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>데이터베이스 테이블 보기</title>
</head>
<body>
<table width="200" border="1">
    <tr>
        <td>아이디</td>
        <td>이름</td>
        <td>나이</td>
    </tr>
        <%
    try {
//        Class.forName("com.mysql.cj.jdbc.Driver");
             // 매번 드라이버를 로딩하는 중복 발생
             // web.xml에 정의해서 톰캣 구동하면 드라이버 로드하게 설정.
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        String jdbcDriver = "jdbc:mysql://localhost:3306/jsp?useUnicode=true&characterEncoding=utf8";
        String user = "jmk";
        String password = "mmk";

        String query = "select * from jsp.member";

        conn = DriverManager.getConnection(jdbcDriver, user, password);
        st = conn.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()){
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
        rs.close();
        st.close();
        conn.close();
    } catch (SQLException e) {
    e.printStackTrace();
    %>
</body>
</html>
