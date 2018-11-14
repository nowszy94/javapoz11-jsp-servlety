package com.sda.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LinksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        resp.addHeader("Content-Type", "text/html");

        writer.println("<div>");
        writer.println("Moje linki:");
        writer.println("<br/>");
        writer.println("<a href=\"http://www.google.com\">Google</a>");
        writer.println("<br/>");
        writer.println("<a href=\"http://pl.wikipedia.com\">Wikipedia</a>");
        writer.println("<br/>");
        writer.println("<a href=\"http://onet.pl\">Onet</a>");
        writer.println("</div>");
    }
}
