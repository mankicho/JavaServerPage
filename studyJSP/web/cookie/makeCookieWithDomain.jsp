<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-27
  Time: 오후 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>도메인 설정</title>
</head>
<body>
쿠키는 그 쿠키를 생성한 서버로만 전송할 수 있다. 하지만 같은 도메인을 사용하는 모든 서버에 쿠키를 보내야 하는 경우에는 <br>
setDomain() 매서드를 사용한다. <br>
예를들어
www.somehost.com 에서 생성한 쿠키를 <br>
1. mail.somehost.com 서버와 <br>
2. javacan.somehost.com 서버 <br>
2개에 전송해야 하는 경우가 있다.
이럴때 <br>
cookie.setDomain(".somehost.com"); 이런식으로 도메인을 설정해주면 <br>
somehost.com를 포함하는 도메인에는 쿠키가 전송된다.
</body>
</html>
