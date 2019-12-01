<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-30
  Time: 오후 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    Connection conn = null;

    PreparedStatement pstmtItem = null;
    PreparedStatement pstmtValue = null;

    String jdbcDriver = "jdbc:mysql://localhost:3306/jsp?useUnicode=true&characterEncoding=utf8";
    String user = "jmk";
    String password = "mmk";

    Throwable occuredException = null;
    try {
        int idValue = Integer.parseInt(id);
        conn = DriverManager.getConnection(jdbcDriver, user, password);
        // JSP를 실행할때마다 connection 생성하면 접속자가 많은 웹 사이트에서는 전체 성능이 낮아짐.
        // 커넥션 풀 기법을 이용.
        conn.setAutoCommit(false);
        System.out.println("conn 연결");

        pstmtItem = conn.prepareStatement("insert into jsp.member values (?,?,?)");
        pstmtItem.setString(1, idValue + "");
        pstmtItem.setString(2, "상품이름 = " + idValue);
        pstmtItem.setInt(3, 32);
        pstmtItem.executeUpdate();

        if (request.getParameter("error") != null) {
            throw new Exception("의도적인 익셉션 발생");
            // exception이 발생하면서 conn을 roll back 시켜 데이터 무결성을 유지한다.
        }

        pstmtValue = conn.prepareStatement("insert into jsp.member values (?,?,?)");
        pstmtValue.setString(1, idValue + " version 2");
        pstmtValue.setString(2, "상품이름 = " + idValue + " version 2");
        pstmtValue.setInt(3, 23);
        pstmtValue.executeUpdate();

        System.out.println("commit 완료");

        conn.commit();

        pstmtValue.close();
        pstmtItem.close();
        conn.close();
    } catch (Throwable e1) {
        System.out.println(e1.toString());
        occuredException = e1;
        try {
            if (conn != null) {
                conn.rollback();
                System.out.println("roll back 되었음");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>
<html>
<head>
    <title>데이터 넣는창.</title>
</head>
<body>
<%
    if (occuredException != null) {
        out.println(occuredException.getMessage());
    } else {
        out.println("데이터 삽입 완료");
    }
%>
</body>
</html>
