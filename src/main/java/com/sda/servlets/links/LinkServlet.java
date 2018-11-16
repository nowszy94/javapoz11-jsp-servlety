package com.sda.servlets.links;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class LinkServlet extends HttpServlet {

    private LinksService linksService;

    @Override
    public void init() throws ServletException {
        this.linksService = LinksService.instanceOf();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getPathInfo().substring(1));
        linksService.delete(id);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();

        ObjectMapper objectMapper = new ObjectMapper();
        Link link = objectMapper.readValue(reader, Link.class);

        Integer id = Integer.valueOf(req.getPathInfo().substring(1));
        link.setId(id);

        linksService.save(link);
    }
}
