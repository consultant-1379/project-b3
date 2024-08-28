package com.ericsson.nativecloud.model;

import javax.persistence.*;

@Entity
@Table(name="leading_questions")
public class LeadingQuestion{

    @Id
    @GeneratedValue
    @Column(name="leading_question_id", nullable = false, unique = true)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="stage_id")
    private Stage stage;
    private String description;

    public LeadingQuestion(){}

    public LeadingQuestion(int id, Stage stageId, String description) {
        this.id = id;
        this.stage = stageId;
        this.description = description;
    }

    public int getID() {
        return id;
    }


    public Stage getStage() {
        return stage;
    }


    public String getDescription() {
        return description;
    }

}
