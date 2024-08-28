package com.ericsson.nativecloud.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StageTest {


    @Test
    void test_that_get_Stage_id_for_leadingQuestion() {
        Stage s1 = new Stage(1, "");
        assertEquals(1,s1.getStageId());
    }

    @Test
    void test_that_get_stage_name_for_leadingQuestion() {
        Stage s1 = new Stage(1, "Culture");
        assertEquals("Culture",s1.getStageName());
    }
}