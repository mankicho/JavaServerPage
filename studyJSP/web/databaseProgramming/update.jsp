<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-28
  Time: 오후 6:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    String name = request.getParameter("name");

    int updateCount = 0;

    try {
//        Class.forName("com.mysql.cj.jdbc.Driver");
        // 매번 드라이버를 로딩하는 중복 발생
        // web.xml에 정의해서 톰캣 구동하면 드라이버 로드하게 설정.

        Connection conn = null;
        Statement st = null;

        String jdbcDriver = "jdbc:mysql://localhost:3306/jsp?useUnicode=true&characterEncoding=utf8";
        String user = "jmk";
        String password = "mmk";

        String query = "update jsp.member set name = '" + name + "' where id = '" + id + "'";

        conn = DriverManager.getConnection(jdbcDriver, user, password);
        st = conn.createStatement();
// updateCount는 변경된 레코드의 개수를 리턴한다.
        updateCount = st.executeUpdate(query);

        st.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
<html>
<head>
    <title>이름 변경</title>
</head>
<body>
<%
    if (updateCount > 0) {
        out.println(id + "를 " + name + "으로 변경");
    } else {
        out.println("아이디가 존재하지 않음");
    }
%>
</body>
</html>
