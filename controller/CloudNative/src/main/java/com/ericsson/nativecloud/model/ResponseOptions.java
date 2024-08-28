package com.ericsson.nativecloud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="response_options")
public class ResponseOptions {

    @Id
    @GeneratedValue
    private int optionsId;
    private String optionDesc;

    public ResponseOptions(){}

    public ResponseOptions(int optionsId, String optionDesc) {
        this.optionsId = optionsId;
        this.optionDesc = optionDesc;
    }

    public int getOptionsId() {
        return optionsId;
    }

    public String getOptionDesc() {
        return optionDesc;
    }
}
