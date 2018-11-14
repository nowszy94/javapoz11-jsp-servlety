<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="names" type="java.util.List<String>"--%>
<c:forEach items="${names}" var="item">
    ${item}<br>
</c:forEach>
</body>
</html>
