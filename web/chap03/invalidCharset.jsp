<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-23
  Time: 오후 12:31
  To change this template use File | Settings | File Templates.
--%>

<!-- charset 을 잘못 지정하는 경우 -->
<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<!-- 다른 클래스를 import해서 사용할 수 있다 -->
<%@ page import="java.util.Date" %>
<%
    Date now = new Date();
%>
<html>
<head>
    <title>현재 시간</title>
</head>
<body>
현재 시각 = <%= now %>
<!-- 사용한 캐릭터 인코딩과 page 디렉티브의 속성에 지정한 캐릭터 셋이 일치하지 않아 깨져서 나온다. -->
</body>
</html>
