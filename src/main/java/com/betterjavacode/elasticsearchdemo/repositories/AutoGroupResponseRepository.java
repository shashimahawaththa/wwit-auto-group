package com.betterjavacode.elasticsearchdemo.repositories;

import com.betterjavacode.elasticsearchdemo.models.AutoGroupData;
import com.betterjavacode.elasticsearchdemo.models.AutoGroupResponse;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AutoGroupResponseRepository extends ElasticsearchRepository<AutoGroupResponse, String>
{

}
