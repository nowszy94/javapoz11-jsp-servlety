<%@ page import="com.sda.servlets.survey.SurveyService" %>
<%@ page import="com.sda.servlets.survey.Survey" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sda.servlets.links.Link" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    SurveyService surveyService = SurveyService.instanceOf();
%>

<ul>
    <%
        List<Survey> surveys = surveyService.findAll();
        for (Survey survey : surveys) {
    %>
        <li><%= survey.getTitle() %></li>
    <% } %>
</ul>



</body>
</html>
