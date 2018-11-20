<%@ page import="com.sda.servlets.links.Link" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sda.servlets.users.UsersService" %>
<h1>Hello world</h1>


<%!
    String message = "Ala ma kota";
    Link link = new Link("http://google.com", "Google");
    Integer age = 20;
    UsersService usersService = UsersService.instanceOf();
%>

<h1>
    <%= message %>
    <%= link.getText() %>
</h1>

<%
    List<String> list = new ArrayList<>();
    list.add("Jan");
    list.add("Anna");
    list.add("Karolina");
    message = "test";
%>

<%= "test" %>

<% if (age > 18) { %>
    <h2>Jestes pelnoletni</h2>
<% } else { %>
    <h2>Jest nieletni</h2>
<% } %>

<%
    if (age > 18) {
        out.println("<h2>Jestes pelnoletni</h2>");
    } else {
        out.println("<h2>Jestes nieletni</h2>");
    }
%>