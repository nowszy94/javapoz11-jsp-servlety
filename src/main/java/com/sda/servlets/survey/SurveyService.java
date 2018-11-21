package com.sda.servlets.survey;

import java.util.ArrayList;
import java.util.List;

public class SurveyService {

    private static SurveyService instance = null;

    public static SurveyService instanceOf() {
        if (instance == null) {
            instance = new SurveyService();
        }
        return instance;
    }

    private List<Survey> surveyList;
    private Integer nextId;

    private SurveyService() {
        this.surveyList = new ArrayList<>();
        this.nextId = 1;
        init();
    }

    public List<Survey> findAll() {
        return new ArrayList<>(surveyList);
    }

    public void save(Survey survey) {
        if (survey.getId() == null) {
            survey.setId(nextId++);
            surveyList.add(survey);
        } else {
            surveyList.stream()
                    .filter(e -> e.getId().equals(survey.getId()))
                    .findAny()
                    .ifPresent(e -> {
                        e.setTitle(survey.getTitle());
                        e.setDescription(survey.getDescription());
                        e.setQuestions(survey.getQuestions());
                    });
        }
    }

    public Survey findById(Integer surveyId) throws SurveyDoesNotExistsException {
        return surveyList.stream()
                .filter(e -> e.getId().equals(surveyId))
                .findAny()
                .orElseThrow(() -> new SurveyDoesNotExistsException(surveyId + ""));
    }

    private void init() {
        save(Survey.builder().title("Stan powietrza w Poznaniu").build());
        save(Survey.builder().title("Zmiana na czas zimowy").build());
        save(Survey.builder().title("Drogi dojazdowe do Poznania").build());
    }
}
