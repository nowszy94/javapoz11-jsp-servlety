package com.sda.servlets.survey;

import java.util.ArrayList;
import java.util.Arrays;
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
        save(Survey.builder()
                .title("Stan powietrza w Poznaniu")
                .description("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Beatae doloribus dolorum esse fugiat hic\n" +
                        "                itaque\n" +
                        "                neque nisi sit sunt voluptatem.")
                .questions(new ArrayList<>(Arrays.asList(
                        SurveyQuestion.builder()
                                .text("Pytanie 1")
                                .answers(Arrays.asList("Odpowiedz 1", "Odpowiedz 2", "Odpowiedz 3", "Odpowiedz 4"))
                        .build(),
                        SurveyQuestion.builder()
                                .text("Pytanie 2")
                                .answers(Arrays.asList("Odpowiedz 1", "Odpowiedz 2", "Odpowiedz 3", "Odpowiedz 4"))
                                .build(),
                        SurveyQuestion.builder()
                                .text("Pytanie 3")
                                .answers(Arrays.asList("Odpowiedz 1", "Odpowiedz 2", "Odpowiedz 3", "Odpowiedz 4"))
                                .build()
                )))
                .build());
        save(Survey.builder()
                .title("Zmiana na czas zimowy")
                .description("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Beatae doloribus dolorum esse fugiat hic\n" +
                        "                itaque\n" +
                        "                neque nisi sit sunt voluptatem.")
                .questions(new ArrayList<>(Arrays.asList(
                        SurveyQuestion.builder()
                                .text("Pytanie 1")
                                .answers(Arrays.asList("Odpowiedz 1", "Odpowiedz 2", "Odpowiedz 3", "Odpowiedz 4"))
                                .build(),
                        SurveyQuestion.builder()
                                .text("Pytanie 2")
                                .answers(Arrays.asList("Odpowiedz 1", "Odpowiedz 2", "Odpowiedz 3", "Odpowiedz 4"))
                                .build(),
                        SurveyQuestion.builder()
                                .text("Pytanie 3")
                                .answers(Arrays.asList("Odpowiedz 1", "Odpowiedz 2", "Odpowiedz 3", "Odpowiedz 4"))
                                .build()
                )))
                .build());
    }
}
