<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-12-23
  Time: 오후 6:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 쓰기</title>
</head>
<body>
<form action="writeArticle.do" method="post">
    <p>제목 : <input type="text" name="title" value="${param.title}}"/>
    </p>
    <p>
        내용 : <textarea name="content" rows="5" cols="30">${param.content}</textarea><br>

    </p>
    <input type="submit" value="새 글 등록"/>
</form>
</body>
</html>
