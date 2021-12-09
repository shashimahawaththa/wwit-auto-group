package com.betterjavacode.elasticsearchdemo.services;

import com.betterjavacode.elasticsearchdemo.models.AutoGroupData;
import com.betterjavacode.elasticsearchdemo.models.AutoGroupResponse;
import com.betterjavacode.elasticsearchdemo.repositories.AutoGroupResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoGroupResponseService
{
    @Autowired
    private AutoGroupResponseRepository autoGroupResponseRepository;

    public AutoGroupResponse getAllAutoGroupResponseForId(String id) {
        return autoGroupResponseRepository.findById(id).get();
    }

    public AutoGroupResponse createAutoGroupResponseIndex(final AutoGroupResponse autoGroupResponse)
    {
        return autoGroupResponseRepository.save(autoGroupResponse);
    }

}
