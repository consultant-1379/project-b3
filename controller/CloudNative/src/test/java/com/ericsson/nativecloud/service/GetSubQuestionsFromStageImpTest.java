package com.ericsson.nativecloud.service;

import com.ericsson.nativecloud.model.Stage;
import com.ericsson.nativecloud.model.SubQuestions;
import com.ericsson.nativecloud.repo.SubQuestionRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class GetSubQuestionsFromStageImpTest {

    @Mock
    private SubQuestionRepo mockRepo;

    @InjectMocks
    private GetSubQuestionsFromStageImp service;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void test_that_sub_questions_found_from_repo() {
        ArrayList<SubQuestions> al = new ArrayList<>();
        SubQuestions s1 = new SubQuestions(1, new Stage(1,"Culture"), "");
        al.add(s1);
        when(mockRepo.findAll()).thenReturn(al);

        service.getSubQfromStage(1);
        assertEquals(1,s1.getID());

        verify(mockRepo).findAll();

    }
}