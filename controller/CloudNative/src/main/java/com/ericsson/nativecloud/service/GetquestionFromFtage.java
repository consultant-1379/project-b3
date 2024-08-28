package com.ericsson.nativecloud.service;

import com.ericsson.nativecloud.model.LeadingQuestion;

import java.util.Optional;

public interface GetquestionFromFtage {
   Optional<LeadingQuestion> getLeadingQuestions(int id);

}
