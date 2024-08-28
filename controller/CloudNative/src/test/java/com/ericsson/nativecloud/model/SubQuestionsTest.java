package com.ericsson.nativecloud.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SubQuestionsTest {



    @Test
    void test_that_getID_for_leadingQuestion() {
        SubQuestions question1 = new SubQuestions(1, null, "");
        assertEquals(1,question1.getID());
    }

    @Test
    void test_that_get_stage_id_for_leadingQuestion() {
        Stage s = new Stage(1,"Culture");
        SubQuestions question1 = new SubQuestions(1, s, "");
        assertEquals(question1.getStage(),s);

    }

    @Test
    void test_that_get_desc_for_leadingQuestion() {
        SubQuestions question1 = new SubQuestions(1, null, "q1");
        assertEquals("q1",question1.getDescription());
    }
}