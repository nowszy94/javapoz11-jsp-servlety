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

    private UsersService usersService;

    @Override
    public void init() throws ServletException {
        this.usersService = UsersService.instanceOf();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html");
        PrintWriter writer = resp.getWriter();

        createForm(writer);

        List<User> users = usersService.findAll();

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);

            writer.println("<a href=\"" + req.getContextPath() + req.getServletPath() + "/" + i + "\">");
            writer.println("<p>" + user.getFirstName() + " " + user.getLastName() + "</p>");
            writer.println("</a>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        UserGender gender = UserGender.valueOf(req.getParameter("gender"));
        Integer age = Integer.valueOf(req.getParameter("age"));

        User user = new User(firstName, lastName, age, gender);
        usersService.save(user);

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
