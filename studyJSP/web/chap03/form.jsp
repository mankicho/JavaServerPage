<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-23
  Time: 오후 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HTML 폼 생성하기</title>
</head>
<body>
<form action="viewParameter.jsp" method="post">
    <!-- get 방식은 요청 URI에 파라미터를 붙여서 전송하는 방식이다.
    예를들어 httml://localhost:8080/chap03/viewParameter.jsp?name=~~~~~~~~~~&address=~~~~ 이런식 -->
    <!-- post 방식은 URI에 파라미터를 붙이는것이 아닌 요청 데이터의 데이터영역에 파라미터 데이터가 들어간다 -->
    이름 : <input type="text" name="name" size="10"><br>
    주소 : <input type="text" name="address" size="30"> <br>
    좋아하는 동물 :
    <input type="checkbox" name="pet" value="dog">강아지
    <input type="checkbox" name="pet" value="cat">고양이
    <input type="checkbox" name="pet" value="pig">돼지
    <br>
    <input type="submit" value="제출"/>
</form>
<!-- 이름 : 조만기 / 주소 : 인천 으로 작성하고 제출을 누르면 파라미터 목록에
name=조만기
address=인천
으로 웹서버에 전송한다. -->
</body>
</html>
