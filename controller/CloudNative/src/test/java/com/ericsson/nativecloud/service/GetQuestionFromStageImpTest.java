package com.ericsson.nativecloud.service;

import com.ericsson.nativecloud.model.LeadingQuestion;
import com.ericsson.nativecloud.model.Stage;
import com.ericsson.nativecloud.repo.QuestionRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class GetQuestionFromStageImpTest {

    @Mock
    private QuestionRepo mockRepo;

    @InjectMocks
    private GetQuestionFromStageImp service;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void test_that_leading_questions_found_from_repo() {

        LeadingQuestion l1 = new LeadingQuestion(1, new Stage(1, "Culture"), "");
        when(mockRepo.findById(anyInt())).thenReturn(Optional.of(l1));

        assertEquals(1,service.getLeadingQuestions(1).get().getID());



    }
}