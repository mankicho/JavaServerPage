<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-27
  Time: 오전 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="member" scope="request" class="javabeen.member.MemberInfo"/>
<%
    request.setCharacterEncoding("UTF-8");
    member.setId("manki");
    member.setName("조만기");
%>
<jsp:forward page="useObject.jsp"/>