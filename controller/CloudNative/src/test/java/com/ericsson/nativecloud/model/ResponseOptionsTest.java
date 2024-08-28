package com.ericsson.nativecloud.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;


class ResponseOptionsTest {

    @Test
    void test_that_get_option_id_for_leadingQuestion() {
        ResponseOptions rs1 = new ResponseOptions(1, "");
        assertThat(rs1.getOptionsId(), is(1));
    }

    @Test
    void test_that_get_option_desc_for_leadingQuestion() {
        ResponseOptions rs1 = new ResponseOptions(1, "YES");
        assertEquals("YES", rs1.getOptionDesc());
    }
}