package com.sda.servlets.users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init() throws ServletException {
        this.usersService = UsersService.instanceOf();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        Integer id = Integer.valueOf(pathInfo.substring(1));
        PrintWriter writer = resp.getWriter();
        try {
            User user = usersService.findById(id);
            displayUser(user, writer);
        } catch (UserNotFoundException e) {
            writer.println(e.getMessage());
            resp.setStatus(404);
        }
    }

    private void displayUser(User user, PrintWriter writer) {
        writer.println(user.getFirstName() + " " + user.getLastName());
        writer.println("Gender: " + user.getGender());
        writer.println("Age: " + user.getAge());
    }
}
