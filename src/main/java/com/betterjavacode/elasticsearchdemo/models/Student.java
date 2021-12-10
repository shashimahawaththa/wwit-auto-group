package com.betterjavacode.elasticsearchdemo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "wwit-student-data")
public class Student {
    @Id
    private String id;

    @Field(type = FieldType.Text, name = "Student Name")
    private String name;

    @Field(type = FieldType.Text, name = "Schedule")
    private String schedule;

    @Field(type = FieldType.Text, name = "Email ID ")
    private String email;

    @Field(type = FieldType.Text, name = "Focus Area/Major ")
    private String focus;

    @Field(type = FieldType.Text, name = "Course ")
    private String course;

    @Field(type = FieldType.Text, name = "Progress")
    private String progress;

    @Field(type = FieldType.Text, name = "Mastery")
    private String mastery;

    @Field(type = FieldType.Text, name = "Physical Location ")
    private String location;

    @Field(type = FieldType.Text, name = "Group")
    private String group;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getMastery() {
        return mastery;
    }

    public void setMastery(String mastery) {
        this.mastery = mastery;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
