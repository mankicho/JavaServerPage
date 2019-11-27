<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-26
  Time: 오후 7:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<!-- request의 encoding 캐릭터를 정해줘야 param 값이 제데로 넘어간다 -->
<html>
<head>
    <title>INFO</title>
</head>
<body>
<table width="100" border="1" cellspacing="0" cellpadding="0">
    <tr>
        <td>제품번호</td>
        <td>XXXX</td>
    </tr>
    <tr>
        <td>가격</td>
        <td>10000원</td>
    </tr>
</table>

<!-- include 할때 param을 지정해서 보낼 수 있다 -->
<jsp:include page="infoSub.jsp" flush="false">
    <jsp:param name="type" value="에이"/>
</jsp:include>
</body>
</html>
