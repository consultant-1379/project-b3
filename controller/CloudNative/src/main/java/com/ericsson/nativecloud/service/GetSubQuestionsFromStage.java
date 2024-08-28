package com.ericsson.nativecloud.service;

import com.ericsson.nativecloud.model.SubQuestions;

import java.util.List;

public interface GetSubQuestionsFromStage {
    List<SubQuestions> getSubQfromStage(int id);
}
