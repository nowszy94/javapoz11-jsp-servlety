package com.sda.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LinksServlet extends HttpServlet {

    private List<Link> links;

    @Override
    public void init() throws ServletException {
        this.links = new ArrayList<>();

        links.add(new Link("http://www.google.com", "Google"));
        links.add(new Link("http://pl.wikipedia.com", "Wikipedia"));
        links.add(new Link("http://onet.pl", "Onet"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        resp.addHeader("Content-Type", "text/html");

        writer.println("<div>");

        String errorMessage = req.getParameter("error_message");
        if (errorMessage != null) {
            writer.println("<p style=\"color: red;\">" + errorMessage + "</p>");
        }

        createForm(writer);

        writer.println("Moje linki:");
        for (Link link : links) {
            writer.println("<br/>");
            writer.println("<a href=\"" + link.getUrl() + "\">" + link.getText() + "</a>");
        }
        writer.println("</div>");
    }

    private void createForm(PrintWriter writer) {
        String form = "<form action=\"\" method=\"post\">\n" +
                "    Link: <input type=\"text\" name=\"link\">\n" +
                "    <br>\n" +
                "    Text: <input type=\"text\" name=\"text\">\n" +
                "    <br>\n" +
                "    <input type=\"submit\">\n" +
                "</form>";
        writer.println(form);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = req.getParameter("link");
        String text = req.getParameter("text");

        StringBuilder redirectBuilder = new StringBuilder();
        redirectBuilder.append(req.getContextPath())
                .append(req.getServletPath());

        if (link == null || text == null) {
            redirectBuilder.append("?error_message=Bledne dane");
        } else {
            Link linkObject = new Link(link, text);
            links.add(linkObject);
        }
        resp.sendRedirect(redirectBuilder.toString());
    }
}
