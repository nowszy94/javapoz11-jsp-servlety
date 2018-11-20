package com.sda.servlets.survey;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SurveyFormDto {
    private String title;
    private String description;
    private Map<String, SurveyQuestion> questions;

    public static SurveyFormDto fromRequest(HttpServletRequest request) {
        SurveyFormDto surveyFormDto = new SurveyFormDto();
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, SurveyQuestion> questions = new HashMap<>();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue()[0];
            if (key.startsWith("question")) {
                String questionId = key.substring("question".length())
                        .substring(0, 1);
                SurveyQuestion surveyQuestion = addIfNeeded(questions, questionId);
                handleRestOfParameter(
                        surveyQuestion,
                        key.substring("question".length() + 1),
                        value);
            } else if ("title".equals(key)) {
                surveyFormDto.title = value;
            } else if ("description".equals(key)) {
                surveyFormDto.description = value;
            }
        }
        surveyFormDto.questions = questions;
        return surveyFormDto;
    }

    private static void handleRestOfParameter(SurveyQuestion surveyQuestion, String key, String value) {
        if ("text".equals(key)) {
            surveyQuestion.setText(value);
        } else if (key.startsWith("answer")) {
            Integer index = Integer.valueOf(key.substring("answer".length())) - 1;
            addAnswer(surveyQuestion, index, value);
        }
    }

    private static void addAnswer(SurveyQuestion surveyQuestion, Integer index, String value) {
        if (surveyQuestion.getAnswers() == null) {
            surveyQuestion.setAnswers(new ArrayList<>());
        }
        List<String> answers = surveyQuestion.getAnswers();
        answers.add(index, value);
    }

    private static SurveyQuestion addIfNeeded(Map<String, SurveyQuestion> questions, String questionId) {
        if (!questions.containsKey(questionId)) {
            questions.put(questionId, SurveyQuestion.builder().build());
        }
        return questions.get(questionId);
    }
}
