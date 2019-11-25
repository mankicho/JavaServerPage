<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-23
  Time: 오후 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("ISO-8859-1");
// setCharacterEncoding은 Http 프로토콜의 데이터영역을 인코딩할때 사용할 캐릭터 셋을 지정한다,
    // post방식을 사용하면 setCharacterEncoding을 해줘야하지만 get방식은 URI에서 파라미터를 전달하기때문에
    // setCharacterEncoding 을 해줄 필요가 없다.
    // get방식으로 보내주면 정상적으로 출력된다.
%>

<html>
<head>
    <title>form.jsp에서 전송한 파라미터 받아와서 보여주는 페이지</title>
</head>
<body>
name 파라미터 = <%=request.getParameter("name")%> <br>
address 파라미터 = <%=request.getParameter("address")%> <br>
</body>
</html>
