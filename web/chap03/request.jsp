<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-23
  Time: 오후 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>request 기본 객체</title>
</head>
<body>
클라이언트 IP = <%=request.getRemoteAddr()%> <br>
요청정보 길이 = <%=request.getContentLength()%> <br>
요청정보 인코딩 = <%= request.getCharacterEncoding()%><br>
요청정보 컨텐트 타입 = <%= request.getContentType()%><br>
요청정보 프로토콜 = <%=request.getProtocol()%><br>
요청정보 전송방식 = <%= request.getMethod()%> <br>
요청 URI = <%=request.getRequestURI()%> <br>
컨텍스트 경로 = <%=request.getContextPath()%> <br>
서버이름 = <%=request.getServerName()%> <br>
서버 포트 = <%=request.getServerPort()%>
</body>
</html>
