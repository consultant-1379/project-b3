package com.ericsson.nativecloud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STAGE")
public class Stage {

    @Id
    @GeneratedValue
    private int stageId;
    private String stageName;

    public Stage(){}

    public Stage(int stageId, String stageName) {
        this.stageId = stageId;
        this.stageName = stageName;
    }

    public int getStageId() {
        return stageId;
    }

    public String getStageName() {
        return stageName;
    }


}
