package com.ericsson.nativecloud.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class SurveyUserTest {

    SurveyUser testUser = new SurveyUser(1,"tom", "123@email.com");
    SurveyUser EmptyUser = new SurveyUser();

    @Test
    void test_that_get_user_id_from_User() {
        assertThat(testUser.getUserId(), is(1));

    }

    @Test
    void setUser_id() {
        EmptyUser.setUserId(2);
        assertThat(EmptyUser.getUserId(), is(2));
    }

    @Test
    void getUser_name() {
        assertThat(testUser.getUserName(), is("tom"));

    }

    @Test
    void setUser_name() {
        EmptyUser.setUserName("john");
        assertThat(EmptyUser.getUserName(), is("john"));
    }

    @Test
    void getUser_email() {
        assertThat(testUser.getUserEmail(), is("123@email.com"));
    }

    @Test
    void setUser_email() {
        EmptyUser.setUserEmail("234@email.com");
        assertThat(EmptyUser.getUserEmail(), is("234@email.com"));
    }
}