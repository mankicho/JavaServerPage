<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-23
  Time: 오후 1:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setHeader("Cache-Control","no-cache"); // 응답 결과를 캐시하지않는다.
    response.addHeader("Cache-Control","no-store"); // 웹 브라우저에서 응답결과를 임시저장소인 캐시에 저장하지않는다.
%>
<html>
<head>
    <title>response 객체</title>
</head>
<body>
응답 정보에 헤더를 추가하는 기능을 제공한다
<br>
1) 캐시 : cpu에서 처리하는 속도와 메모리에 데이터를 올리는 속도차이를 극복하기위해서 자주 사용하는 데이터를 저장해두는 임시 데이터 저장소. <br>
웹브라우저가 웹서버에 요청하면 첫번째 응답결과를 캐시에 저장한다. 이후 동일한 url에 대한 요청이있으면 web application server에 접근하지않고 캐시에 바로접근해 <br>
빠르게 응답결과를 웹 브라우저에 출력한다.<br><br>

2) 리다이렉트 : 웹 브라우저에게 다른 페이지로 이동하라고 응답하는 기능. 로그인에 성공하면 메인페이지로 자동이동하는 것 등 <br>
<form action="loginFail.jsp" method="post">
    <input type="text" name="name"><br>
    <input type="submit" value="로그인">
</form>

</body>
</html>
