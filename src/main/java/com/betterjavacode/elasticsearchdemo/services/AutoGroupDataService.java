package com.betterjavacode.elasticsearchdemo.services;

import com.betterjavacode.elasticsearchdemo.models.AutoGroupData;
import com.betterjavacode.elasticsearchdemo.models.AutoGroupResponse;
import com.betterjavacode.elasticsearchdemo.repositories.AutoGroupDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoGroupDataService
{
    @Autowired
    private AutoGroupDataRepository autoGroupDataRepository;

    public AutoGroupData createAutoGroupDataIndex(final AutoGroupData autoGroupData)
    {
        return autoGroupDataRepository.save(autoGroupData);
    }

    public AutoGroupData getAllAutoGroupDataForId (String id)
    {
        return autoGroupDataRepository.findById(id).get();
    }

    public Iterable<AutoGroupData> createLogDataIndices(final List<AutoGroupData> autoGroupDataList)
    {
        return autoGroupDataRepository.saveAll(autoGroupDataList);
    }
}
