<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-24
  Time: 오후 3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP 기본 객체</title>
</head>
<body>
<%
    out.println("JSP 페이지가 생성하는 모든 내용은 out 기본 객체를 통해 전송된다.");
    //
%>

<br>
<%
    HttpServletRequest httpServletRequest = (HttpServletRequest) pageContext.getRequest();
%>
request 기본객체와 pageContext.getRequest()이 객체가 같은지 동일 여부 : <%=request == httpServletRequest%>

<br>

pageContext를 이용한 데이터 출력 <br>
<%
    pageContext.getOut().println("pageContext 객체를 이용해 출력했습니다.");
%>

request 기본 객체 = <%=pageContext.getRequest()%><br>
response 기본 객체 = <%=pageContext.getResponse()%> <br>
session 기본객체 =<%=pageContext.getSession()%><br>
application 기본객체 =<%=pageContext.getServletContext()%><br>
config 기본 객체 =<%=pageContext.getServletConfig()%><br>
out 기본 객체 =<%=pageContext.getOut()%><br>
page 기본 객체 =<%=pageContext.getPage()%>

<br><br>
web.xml에 초기화 파라미터를 추가하고 application 기본객체를 사용해 초기화파라미터 불러오기. <br>
초기화 파라미터 목록:

<%
    Enumeration<String> initParamEnum = application.getInitParameterNames();
    while (initParamEnum.hasMoreElements()) {
        String initParamName = initParamEnum.nextElement();
        out.print(initParamName+" = ");
        out.println(application.getInitParameter(initParamName));
    }
%>
<br><br>
application 기본객체를 이용한 로그파일에 로그남기기. <br>
<%
    application.log("로그 메세지 남기기");
%>
로그 메세지를 기록합니다. 톰캣 설치폴더의 logs 파일에 로그를 남길수있다.
<br>

</body>
</html>
