package com.betterjavacode.elasticsearchdemo.repositories;

import com.betterjavacode.elasticsearchdemo.models.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface StudentRepository extends ElasticsearchRepository<Student, String>
{

}
