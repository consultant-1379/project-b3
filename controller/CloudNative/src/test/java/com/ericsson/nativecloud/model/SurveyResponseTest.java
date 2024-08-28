package com.ericsson.nativecloud.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class SurveyResponseTest {

    private Stage s = new Stage(1,"Culture");
    private LeadingQuestion question1 = new LeadingQuestion(1, s, "q1");
    private SubQuestions subquestion1 = new SubQuestions(1, s, "");
    private ResponseOptions rs1 = new ResponseOptions(1, "");
    private SurveyUser user = new SurveyUser(1,"tom", "123@email.com");

    SurveyResponse surveyResponse = new SurveyResponse(1,user,subquestion1,question1,s,rs1);

    @Test
    void test_that_get_survey_response_id_for_a_survey() {
        assertThat(surveyResponse.getSurveyResponseId(), is(1));

    }

    @Test
    void test_that_get_user_from_a_survey() {
        assertThat(surveyResponse.getUserId(), is(user));
    }

    @Test
    void test_that_get_subquestions_from_a_survey() {
        assertThat(surveyResponse.getSubQuestionsId(), is(subquestion1));
    }

    @Test
    void test_that_get_leading_question_from_a_survey() {
        assertThat(surveyResponse.getLeadingQuestionId(), is(question1));
    }

    @Test
    void test_that_get_stage_from_a_survey() {
        assertThat(surveyResponse.getStageId(), is(s));
    }

    @Test
    void test_that_get_options_from_a_survey() {
        assertThat(surveyResponse.getOptionsId(), is(rs1));
    }
}