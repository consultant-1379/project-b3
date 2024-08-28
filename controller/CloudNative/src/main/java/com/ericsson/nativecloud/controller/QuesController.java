package com.ericsson.nativecloud.controller;

import com.ericsson.nativecloud.model.LeadingQuestion;
import com.ericsson.nativecloud.model.SubQuestions;
import com.ericsson.nativecloud.model.SurveyUser;
import com.ericsson.nativecloud.model.SurveyUserDTO;
import com.ericsson.nativecloud.service.ShowStageImp;
import com.ericsson.nativecloud.service.GetQuestionFromStageImp;
import com.ericsson.nativecloud.service.GetSubQuestionsFromStageImp;
import com.ericsson.nativecloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class QuesController {

    @Autowired
    private GetQuestionFromStageImp getQFromStage;

    @Autowired
    private ShowStageImp showStage;

    @Autowired
    private GetSubQuestionsFromStageImp getSubquestionsFromStageImp;

    @Autowired
    private UserService userService;


    @GetMapping(value="/questions/{id}/subQuestions", produces={"application/json"})
    public ResponseEntity<HashMap<String, List<SubQuestions>>> showSubQuestion(@PathVariable int id) {
        HashMap<String, List<SubQuestions>> hs = new HashMap<>();
        String stageName = this.showStage.getStageName(id);
        List<SubQuestions> subQuestionsList;
        subQuestionsList = getSubquestionsFromStageImp.getSubQfromStage(id);
        hs.put(stageName,subQuestionsList);

        return ResponseEntity.ok(hs);
    }

    @GetMapping(value="/questions/{id}", produces={"application/json"})
    public ResponseEntity<HashMap<String, Optional<LeadingQuestion>>> showLeadingQuestion(@PathVariable int id) {
        HashMap<String, Optional<LeadingQuestion>> hs = new HashMap<>();
        String stageName = this.showStage.getStageName(id);
        Optional<LeadingQuestion> leadingQuestion= getQFromStage.getLeadingQuestions(id);
        hs.put(stageName,leadingQuestion);
        return ResponseEntity.ok(hs);
    }

    @GetMapping(value="/users", produces={"application/json"})
    public Iterable<SurveyUser> listUsers() {
        return userService.listAllUser();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<SurveyUser> getUser(@PathVariable Integer id) {

        SurveyUser user = userService.getUser(id);
        return ResponseEntity.ok().body(user);

    }
    @PostMapping(value="/home", produces={"application/json"}, consumes = {"application/json"})
    public void addUser(@RequestBody SurveyUserDTO userSurvey) {
        SurveyUser surveyUser = new SurveyUser();
        userService.saveUser(surveyUser);
    }

}