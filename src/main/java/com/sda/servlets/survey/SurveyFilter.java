package com.sda.servlets.survey;

import javax.servlet.*;
import java.io.IOException;

public class SurveyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("in filter");
        chain.doFilter(request, response);
    }
}
