package com.betterjavacode.elasticsearchdemo.controllers;

import com.betterjavacode.elasticsearchdemo.models.AutoGroupData;
import com.betterjavacode.elasticsearchdemo.models.Student;
import com.betterjavacode.elasticsearchdemo.services.AutoGroupDataService;
import com.betterjavacode.elasticsearchdemo.services.StudentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/v1/peergroup/autogroupdata")
public class AutoGroupDataController {
    @Autowired
    private AutoGroupDataService autoGroupDataService;
    @Autowired
    private StudentDetailsService studentDetailsService;

    @PostMapping
    public List<Student> addAutoGroupData(@RequestBody AutoGroupData autoGroupData) throws InterruptedException {
        autoGroupDataService.createAutoGroupDataIndex(autoGroupData);
        Thread.sleep(5000);
        AutoGroupData processedAutoGroupData = searchAutoGroupDataById(autoGroupData.getId());
        if (!(processedAutoGroupData.getGroupingStatus().equals("todo"))) {
            Thread.sleep(5000);
            processedAutoGroupData = searchAutoGroupDataById(autoGroupData.getId());
        }
        return filterSelectedStudents(processedAutoGroupData);
    }

    private List<Student> filterSelectedStudents(AutoGroupData autoGroupData) {
        List<Student> allStudents = getAllStudentsDetails();
        List<Student> studentsSubset = allStudents.stream()
                .filter(s -> autoGroupData.getPupils().contains(s.getName()))
                .collect(Collectors.toList());
        return studentsSubset;
    }

    @GetMapping("/studentsdetails")
    public List<Student> getAllStudentsDetails() {
        return studentDetailsService.getAllStudentsDetails();
    }

    @GetMapping("/initrequest/{id}")
    public AutoGroupData searchAutoGroupDataById(@PathVariable("id") String id) {
        AutoGroupData autoGroupData = autoGroupDataService.getAllAutoGroupDataForId(id);
        return autoGroupData;
    }
}
