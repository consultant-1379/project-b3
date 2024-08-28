package com.ericsson.nativecloud.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.*;



class LeadingQuestionTest {


    @Test
    void test_that_getID_for_leadingQuestion() {
        LeadingQuestion question1 = new LeadingQuestion(1, null, "");
        assertEquals(1,question1.getID());
    }

    @Test
    void test_that_getStage_for_leadingQuestion() {
        Stage s = new Stage(1,"Culture");
        LeadingQuestion question1 = new LeadingQuestion(1, s, "q1");
        assertThat(question1.getStage(), is(s));
    }

    @Test
    void test_that_getDescription_for_leadingQuestion() {
        LeadingQuestion question1 = new LeadingQuestion(1, new Stage(1,"Culture"), "q1");
        assertThat(question1.getDescription(), is("q1"));
    }

}