package com.sda.servlets.users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UsersServlet extends HttpServlet {

    private List<User> users;

    @Override
    public void init() throws ServletException {
        this.users = new ArrayList<>();

        this.users.add(new User("Szymon", "Nowak", 55, UserGender.Male));
        this.users.add(new User("Anna", "Kowalska", 33, UserGender.Female));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html");
        PrintWriter writer = resp.getWriter();

        createForm(writer);

        users.forEach(user -> {
            writer.println("<p>" + user.getFirstName() + " " + user.getLastName() + "(" + user.getGender() + ") Age: " + user.getAge() + "</p>");
        });
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        UserGender gender = UserGender.valueOf(req.getParameter("gender"));
        Integer age = Integer.valueOf(req.getParameter("age"));

        User user = new User(firstName, lastName, age, gender);
        users.add(user);

        resp.sendRedirect(req.getContextPath() + req.getServletPath());
    }

    private void createForm(PrintWriter writer) {
        String form = "<form action=\"\" method=\"post\">\n" +
                "    First Name: <input type=\"text\" name=\"firstName\"><br>\n" +
                "    Last Name: <input type=\"text\" name=\"lastName\"><br>\n" +
                "    Age: <input type=\"number\" name=\"age\"><br>\n" +
                "    Gender: \n" +
                "    <select name=\"gender\">\n" +
                "        <option value=\"Female\">Female</option>\n" +
                "        <option value=\"Male\">Male</option>\n" +
                "    </select> <br>\n" +
                "\n" +
                "    <input type=\"submit\">\n" +
                "</form>";
        writer.println(form);
    }
}
