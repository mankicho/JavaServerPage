<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-24
  Time: 오후 3:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = request.getParameter("name");
    String value = request.getParameter("value");

    if (name != null && value != null) {
        application.setAttribute(name, value);
    }
%>

<html>
<head>
    <title>기본 객체와 영역</title>
</head>
<body>
PAGE 영역 : 하나의 JSP 페이지를 처리할때 사용되는 영역 <br>
한번의 클라이언트 요청에 대해 하나의 JSP 페이지를 범위로 갖는다. 웹 브라우저의 요청이 들어오면 JSP 페이지를 실행하는데 이때 JSP 페이지를 실행하는
범위가 하나의 PAGE 영역이 된다. <br><br>

REQUEST 영역 : 하나의 HTTP 요청을 처리할때 사용되는 영역 <br>
한번의 웹 브라우저 요청과 관련. 웹 브라우저의 주소에 URL을 입력하거나 링크를 클릭해서 페이지를 이동할 때 웹 브라우저가 웹 서버에 전송하는 요청이 하나의
REQUEST 영역이 된다. <br>
웹 브라우저가 요청을 보낼때마다 새로운 REQUEST 영역이 생성된다. PAGE는 하나의 JSP 페이지만 포함하지만 REQUESㅆ 영역은하나의 요청을 처리하는데 사용되는 모든
JSP를 포함한다 <br>

SESSION 영역 : 하나의 웹 브라우저와 관련된 영역 <br>
하나의 웹 브라우저와 관련된 영역이다. <br>

APPLICATION 영역 : 하나의 웹 어플리케이션과 관련된 영역 <br>

JSP 기본객체들은 속성을 갖고있다. 기본 객체가 존재하는동안 속성을 이용할수있다.<br>
application 기본객체의 속성: <%=name%> = <%=value%> <br>

<%
    Enumeration<String> attrEnum = application.getAttributeNames();
    while (attrEnum.hasMoreElements()) {
        String nameEnum = attrEnum.nextElement();
        Object valueEnum = application.getAttribute(nameEnum);
        out.println("application 속성 = " + nameEnum + " = " + valueEnum + "\n");
        out.println("\n");
    }
%>
</body>
</html>
