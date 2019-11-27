<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2019-11-27
  Time: 오전 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String code = request.getParameter("code");
    String url = null;

    if(code.equals("A")){
        url = "A.jsp";
    }else if(code.equals("B")){
        url = "B.jsp";
    }else{
        url = "C.jsp";
    }
%>

<jsp:forward page="<%=url%>"/>