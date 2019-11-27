<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-27
  Time: 오전 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>회원가입</title>
</head>
<body>
<form action="processJoining.jsp" method="post">
    <table border="1" cellspacing="0" cellpadding="0">
        <tr>
            <td>아이디</td>
            <td colspan="3"><input type="text" name="id" size="10"/></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" size="10"/></td>
            <td>이메일</td>
            <td><input type="text" name="email" size="10"/></td>
        </tr>

        <tr>
            <td colspan="4" align="center">
                <input type="submit" value="가입"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
