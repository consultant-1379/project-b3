package com.ericsson.nativecloud.service;

import com.ericsson.nativecloud.model.Stage;
import com.ericsson.nativecloud.repo.StageRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ShowStageImpTest {

    @Mock
    private StageRepo mockRepo;

    @InjectMocks
    private ShowStageImp service;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void test_that_stage_found_from_repo() {

        Stage s1 = new Stage(1, "Culture");
        when(mockRepo.findById(anyInt())).thenReturn(Optional.of(s1));

        service.getStageName(1);
        assertEquals("Culture",s1.getStageName());

        verify(mockRepo).findById(anyInt());

        assertFalse(mockRepo.findById(10).get().getStageName().isBlank());
    }
}