package com.ericsson.nativecloud.model;

import javax.persistence.*;

@Entity
@Table(name="survey_response")
public class SurveyResponse {

    @Id
    @GeneratedValue
    private int surveyResponseId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private SurveyUser userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="subQuestions_id")
    private SubQuestions subQuestionsId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="leading_question_id")
    private LeadingQuestion leadingQuestionId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="stage_id")
    private Stage stageId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="options_id")
    private ResponseOptions optionsId;

    public SurveyResponse(){}

    public SurveyResponse(int surveyResponseId, SurveyUser userId, SubQuestions subQuestionsId, LeadingQuestion leadingQuestionId, Stage stageId, ResponseOptions optionsId) {
        this.surveyResponseId = surveyResponseId;
        this.userId = userId;
        this.subQuestionsId = subQuestionsId;
        this.leadingQuestionId = leadingQuestionId;
        this.stageId = stageId;
        this.optionsId = optionsId;
    }

    public int getSurveyResponseId() {
        return surveyResponseId;
    }


    public SurveyUser getUserId() {
        return userId;
    }

    public SubQuestions getSubQuestionsId() {
        return subQuestionsId;
    }

    public LeadingQuestion getLeadingQuestionId() {
        return leadingQuestionId;
    }

    public Stage getStageId() {
        return stageId;
    }

    public ResponseOptions getOptionsId() {
        return optionsId;

    }
}
