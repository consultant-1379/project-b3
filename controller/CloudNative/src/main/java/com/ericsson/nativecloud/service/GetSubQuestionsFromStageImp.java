package com.ericsson.nativecloud.service;

import com.ericsson.nativecloud.model.SubQuestions;
import com.ericsson.nativecloud.repo.SubQuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetSubQuestionsFromStageImp implements GetSubQuestionsFromStage {

    @Autowired
    private SubQuestionRepo subQuestionRepo;

    @Override
    public List<SubQuestions> getSubQfromStage(int id) {
        List<SubQuestions> subQuestionsList = new ArrayList<>();
        subQuestionRepo.findAll().forEach(subQuestionsList::add);
        List<SubQuestions> subQuestionsfromStage = new ArrayList<>();
        for(SubQuestions s: subQuestionsList){
            if(s.getStage().getStageId()==id){
                subQuestionsfromStage.add(s);
            }
        }
        return subQuestionsfromStage;

    }
}
