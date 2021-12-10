package com.betterjavacode.elasticsearchdemo.services;
import com.betterjavacode.elasticsearchdemo.models.Student;
import com.betterjavacode.elasticsearchdemo.repositories.StudentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDetailsService
{
    @Autowired
    private StudentDetailsRepository studentDetailsRepository;

    public List<Student> getAllStudentsDetails() {
       return studentDetailsRepository.findAll(PageRequest.of(0,35)).toList();
    }
}
