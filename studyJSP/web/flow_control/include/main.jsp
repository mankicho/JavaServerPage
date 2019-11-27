<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-25
  Time: 오후 2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
jsp:include 액션 태그 처리과정 <br>
1. main.jsp가 웹 브라우저의 요청을 받음 <br>
2. 출력 내용 A를 버퍼에 저장. <br>
3. include 태그를 만나면 sub.jsp로 이동. <br>
4. sub.jsp의 출력내용 B를 버퍼에 저장 <br>
5. sub.jsp의 실행이 끝나면 요청흐름이 다시 main.jsp로 돌아온다. <br>
6. include 이후 부분인 출력내용 C를 버퍼에 저장한다. <br>
7. 버퍼를 flush 한다. <br><br>

<jsp:include page="sub.jsp" flush="false"/>

공통 영역을 별도의 JSP로 작성한다. 그리고 공통영역을 include 태그를 이용하여 포함시킨다.
layout1.jsp와 layout2.jsp를 봤을 때 알수있는 사실은 include태그를 이용하여 구성요소에 대한 모듈로 사용할 수 있는것이다.
include 액션 태그는 포함할 JSP페이지에 따라 파라미터를 추가할 수 있다.
</body>
</html>
