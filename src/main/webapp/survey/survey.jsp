<%@ page import="com.sda.servlets.survey.Survey" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 20.11.2018
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${survey}
    <br>
<%
    Survey survey = (Survey) request.getAttribute("survey");
    out.println(survey);
%>
</body>
</html>
