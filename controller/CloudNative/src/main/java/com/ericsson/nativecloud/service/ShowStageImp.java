package com.ericsson.nativecloud.service;

import com.ericsson.nativecloud.model.Stage;
import com.ericsson.nativecloud.repo.QuestionRepo;
import com.ericsson.nativecloud.repo.StageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowStageImp implements ShowStage{

    @Autowired
    private StageRepo stageRepo;

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public String getStageName(int id) {
        Optional<Stage> stage = this.stageRepo.findById(id);
        if(stage.isPresent()){
            Stage s = stage.get();

            return s.getStageName();
        }
        return null;

    }

}
