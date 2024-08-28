package com.ericsson.nativecloud.controller;

import com.ericsson.nativecloud.model.LeadingQuestion;
import com.ericsson.nativecloud.model.Stage;
import com.ericsson.nativecloud.model.SubQuestions;
import com.ericsson.nativecloud.model.SurveyUser;
import com.ericsson.nativecloud.repo.QuestionRepo;
import com.ericsson.nativecloud.repo.StageRepo;
import com.ericsson.nativecloud.repo.SubQuestionRepo;
import com.ericsson.nativecloud.repo.UserRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class QuesControllerTest {


    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private StageRepo stageRepo;

    @MockBean
    private QuestionRepo questionRepo;

    @MockBean
    private SubQuestionRepo subQuestionRepo;

    @MockBean
    private UserRepo userRepo;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void test_that_sub_questions_is_sent_by_rest() throws Exception {
        Stage s = new Stage(1,"AAA");
        SubQuestions subQuestions = new SubQuestions(1,s,"q1");


        Mockito.when(stageRepo.findById(1)).thenReturn(Optional.of(s));
        assertThat(s.getStageName(),is("AAA"));

        Mockito.when(subQuestionRepo.findById(1)).thenReturn(Optional.of(subQuestions));
        assertThat(subQuestions.getDescription(),is("q1"));

        mvc.perform(get("/questions/1/subQuestions"))
                .andExpect(status().isOk());

    }



    @Test
    void test_that_leading_questions_is_sent_by_rest() throws Exception {

       Stage s = new Stage(1,"AAA");
       LeadingQuestion leadingQuestion = new LeadingQuestion(1,s,"aaa");

        Mockito.when(stageRepo.findById(1)).thenReturn(Optional.of(s));
        assertThat(s.getStageName(),is("AAA"));

        Mockito.when(questionRepo.findById(1)).thenReturn(Optional.of(leadingQuestion));
        assertThat(leadingQuestion.getDescription(),is("aaa"));

        mvc.perform(get("/questions/1"))
                .andExpect(status().isOk());

    }

    @Test
    void test_that_list_of_users_is_sent_by_rest() throws Exception {
        SurveyUser surveyUser = new SurveyUser(1,"john", "123@email.com");
        Mockito.when(userRepo.findById(1)).thenReturn(Optional.of(surveyUser));
        assertThat(surveyUser.getUserName(),is("john"));

        mvc.perform(get("/users"))
                .andExpect(status().isOk());
    }

    @Test
    void test_that_user_found_from_post_request() throws Exception {
        SurveyUser user = new SurveyUser(1, "john", "zaphod@galaxy.net");

        mvc.perform(post("/home")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());

    }

    @Test
    void test_that_user_is_sent_by_rest() throws Exception {
        SurveyUser surveyUser = new SurveyUser(1,"john", "123@email.com");
        Mockito.when(userRepo.findById(1)).thenReturn(Optional.of(surveyUser));
        assertThat(surveyUser.getUserName(),is("john"));

        mvc.perform(get("/users/1"))
                .andExpect(status().isOk());


    }


}