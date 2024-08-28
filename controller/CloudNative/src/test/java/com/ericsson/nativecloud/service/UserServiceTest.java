package com.ericsson.nativecloud.service;

import com.ericsson.nativecloud.model.SurveyUser;
import com.ericsson.nativecloud.repo.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepo mockRepo;

    @InjectMocks
    private UserService service;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void test_that_list_of_user_found_from_repo() {

        ArrayList<SurveyUser> al = new ArrayList<>();

        SurveyUser s1= new SurveyUser(1,"john", "123@email.com");
        al.add(s1);
        when(mockRepo.findAll()).thenReturn(al);

        service.listAllUser();
        verify(mockRepo).findAll();

    }

    @Test
    void test_that_user_store_into_repo() {
        SurveyUser s1= new SurveyUser(1,"john", "123@email.com");
        when(mockRepo.findById(1)).thenReturn(Optional.of(s1));
        assertThat(mockRepo.findById(1).get(),is(s1));

        assertFalse(mockRepo.findById(2).isPresent());

    }


}