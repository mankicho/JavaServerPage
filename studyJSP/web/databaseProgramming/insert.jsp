<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %><%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-29
  Time: 오전 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    Connection conn = null;
    PreparedStatement pst = null;
    try {
//        Class.forName("com.mysql.cj.jdbc.Driver");
        // 매번 드라이버를 로딩하는 중복 발생
        // web.xml에 정의해서 톰캣 구동하면 드라이버 로드하게 설정.

        String jdbcUrl = "jdbc:mysql://localhost:3306/jsp?useUnicode=true&characterEncoding=utf8";
        String user = "jmk";
        String password = "mmk";

        conn = DriverManager.getConnection(jdbcUrl, user, password);
        pst = conn.prepareStatement("insert into jsp.member values(?,?,?)");
        pst.setString(1, id);
        pst.setString(2, name);
        pst.setInt(3, age);

        pst.executeUpdate();

        pst.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
<html>
<head>
    <title>데이터베이스에 삽입하기.</title>
</head>
<body>
member 테이블에 새로운 레코드를 삽입했습니다.
</body>
</html>
