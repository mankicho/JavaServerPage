<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-25
  Time: 오후 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>layout 2</title>
</head>
<body>
<table width="400" border="1" cellpadding="0" cellspacing="0">
    <tr>
        <td colspan="2">
            <jsp:include page="../module/top.jsp" flush="false"/>
        </td>
    </tr>
    <tr>
        <td width="100" valign="top">
            <jsp:include page="../module/left.jsp" flush="false"/>
        </td>
        <td width="300" valign="top">
            이 부분은 layout2가 생성합니다. <br>
            레이아웃 2
            <br><br><br>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <jsp:include page="../module/bottom.jsp" flush="false"/>
        </td>
    </tr>
</table>
</body>
</html>
