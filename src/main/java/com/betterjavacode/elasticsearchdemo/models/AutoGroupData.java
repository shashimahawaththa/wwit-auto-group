package com.betterjavacode.elasticsearchdemo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.ArrayList;
import java.util.List;

@Document(indexName = "autogroupdataindex")
public class AutoGroupData
{
    @Id
    private String id;

    private List<String> pupils = new ArrayList<>();

    @Field(type = FieldType.Integer, name = "noOfGroups")
    private int noOfGroups;

    @Field(type = FieldType.Integer, name = "noOfPupilsPerGroup")
    private int noOfPupilsPerGroup;

    @Field(type = FieldType.Boolean, name = "focus")
    private boolean focus;

    @Field(type = FieldType.Boolean, name = "schedule")
    private boolean schedule;

    @Field(type = FieldType.Text, name = "groupingStatus")
    private String groupingStatus;

    public boolean isFocus() {
        return focus;
    }

    public int getNoOfGroups() {
        return noOfGroups;
    }

    public void setNoOfGroups(int noOfGroups) {
        this.noOfGroups = noOfGroups;
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
    }

    public boolean isSchedule() {
        return schedule;
    }

    public void setSchedule(boolean schedule) {
        this.schedule = schedule;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getPupils() {
        return pupils;
    }

    public void setPupils(List<String> pupils) {
        this.pupils = pupils;
    }

    public int getNoOfPupilsPerGroup() {
        return noOfPupilsPerGroup;
    }

    public void setNoOfPupilsPerGroup(int noOfPupilsPerGroup) {
        this.noOfPupilsPerGroup = noOfPupilsPerGroup;
    }

    public String getGroupingStatus() {
        return groupingStatus;
    }

    public void setGroupingStatus(String groupingStatus) {
        this.groupingStatus = groupingStatus;
    }
}
