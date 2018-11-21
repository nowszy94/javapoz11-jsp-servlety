package com.sda.servlets.survey;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SurveysServlet extends HttpServlet {

    private SurveyService surveyService;

    @Override
    public void init() throws ServletException {
        this.surveyService = SurveyService.instanceOf();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if (StringUtils.isEmpty(pathInfo) || "/".equals(pathInfo)) {
            req.getRequestDispatcher("survey/surveys.jsp").forward(req, resp);
        } else {
            Integer surveyId = Integer.valueOf(pathInfo.substring(1));
            Survey survey = null;
            try {
                survey = surveyService.findById(surveyId);
                req.setAttribute("survey", survey);
                req.getRequestDispatcher("survey/survey.jsp").forward(req, resp);
            } catch (SurveyDoesNotExistsException e) {
                req.getRequestDispatcher("survey/survey-not-found.jsp").forward(req, resp);
                resp.setStatus(404);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Survey survey = SurveyFormDto.fromRequest(req).toDomain();
        surveyService.save(survey);
        resp.sendRedirect(req.getContextPath() + req.getServletPath());
    }
}
