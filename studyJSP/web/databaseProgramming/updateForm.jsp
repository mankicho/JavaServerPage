<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-28
  Time: 오후 6:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>이름 변경 폼</title>
</head>
<body>
<form action="update.jsp" method="post">
    <table border="1">
        <tr>
            <td>아이디</td>
            <td><input type="text" name="id" size="10"/></td>
            <td>이름<input type="text" name="name" size="10"/></td>
        </tr>
        <tr>
            <td colspan="4"><input type="submit" value="변경"/></td>
        </tr>
    </table>
</form>
</body>
</html>
