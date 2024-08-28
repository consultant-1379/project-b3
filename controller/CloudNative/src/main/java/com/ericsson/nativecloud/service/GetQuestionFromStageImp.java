package com.ericsson.nativecloud.service;

import com.ericsson.nativecloud.model.LeadingQuestion;
import com.ericsson.nativecloud.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetQuestionFromStageImp implements GetquestionFromFtage {

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public Optional<LeadingQuestion> getLeadingQuestions(int id) {
        return questionRepo.findById(id);

    }
}
