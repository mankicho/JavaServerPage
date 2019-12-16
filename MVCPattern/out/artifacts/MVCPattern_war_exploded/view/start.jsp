<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-12-14
  Time: 오후 4:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>시작페이지</title>
</head>
<body>
시작페이지 입니다.
<form action="/board/write.do" method="post">
    <input type="submit" value="글쓰기"/>
</form>
<form action="/board/list.show" method="post">
    <input type="submit" value="글 목록"/>
</form>
</body>
</html>
