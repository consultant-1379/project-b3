package com.ericsson.nativecloud.model;

import javax.persistence.*;

@Entity
@Table(name="sub_questions")
public class SubQuestions{

    @Id
    @GeneratedValue
    @Column(name="sub_question_id", nullable = false, unique = true)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="stage_id")
    private Stage stage;

    private String description;

    public SubQuestions(){}

    public SubQuestions(int id, Stage stage, String description) {
        this.id = id;
        this.stage = stage;
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
