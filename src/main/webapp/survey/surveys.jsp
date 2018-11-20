<%@ page import="com.sda.servlets.survey.SurveyService" %>
<%@ page import="com.sda.servlets.survey.Survey" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sda.servlets.links.Link" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

    </style>
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
    <li><%= survey.getTitle() %>
    </li>
    <% } %>
</ul>

<br>

<form action="" method="post" class="form">
    <div>Title: <input type="text" name="title"> <br></div>
    <div>Description: <textarea name="description" id="" cols="30" rows="10"></textarea></div>
    <div class="form">
        <div class="form">
            <h2>Question1:</h2>
            <div>
                Text: <input type="text" name="question1text">
            </div>
            <div>
                Answers <input type="text" name="question1answer1">,
                <input type="text" name="question1answer2">,
                <input type="text" name="question1answer3">,
                <input type="text" name="question1answer4">
            </div>
        </div>
        <div class="form">
            <h2>Question2:</h2>
            <div>
                Text: <input type="text" name="question2text">
            </div>
            <div>
                Answers <input type="text" name="question2answer1">,
                <input type="text" name="question2answer2">,
                <input type="text" name="question2answer3">,
                <input type="text" name="question2answer4">
            </div>
        </div>
    </div>

    <input type="submit" value="Dodaj">
</form>


</body>
</html>
