package com.betterjavacode.elasticsearchdemo.repositories;

import com.betterjavacode.elasticsearchdemo.models.AutoGroupData;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AutoGroupDataRepository extends ElasticsearchRepository<AutoGroupData, String>
{

}
