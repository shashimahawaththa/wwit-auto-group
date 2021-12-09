package com.betterjavacode.elasticsearchdemo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Document(indexName = "autogroupresponseindex")
public class AutoGroupResponse {

    @Id
    private String id;

    private Map<String,List<String>> groupCollection = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, List<String>> getGroupCollection() {
        return groupCollection;
    }

    public void setGroupCollection(Map<String, List<String>> groupCollection) {
        this.groupCollection = groupCollection;
    }
}
