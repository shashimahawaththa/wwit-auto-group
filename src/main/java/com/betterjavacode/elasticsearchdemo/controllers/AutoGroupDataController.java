package com.betterjavacode.elasticsearchdemo.controllers;

import com.betterjavacode.elasticsearchdemo.models.AutoGroupData;
import com.betterjavacode.elasticsearchdemo.models.AutoGroupResponse;
import com.betterjavacode.elasticsearchdemo.services.AutoGroupDataService;
import com.betterjavacode.elasticsearchdemo.services.AutoGroupResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/peergroup/autogroupdata")
public class AutoGroupDataController
{
    @Autowired
    private AutoGroupDataService autoGroupDataService;
    @Autowired
    private AutoGroupResponseService autoGroupResponseService;

    @PostMapping
    public AutoGroupResponse addAutoGroupData(@RequestBody AutoGroupData autoGroupData) throws InterruptedException {
        autoGroupDataService.createAutoGroupDataIndex(autoGroupData);
        Thread.sleep(30000);
        AutoGroupResponse autoGroupResponse = searchAutoGroupResponseById(autoGroupData.getId());
        if(autoGroupResponse.getId() == null || autoGroupResponse.getId() == "") {
            Thread.sleep(30000);
            autoGroupResponse = searchAutoGroupResponseById(autoGroupData.getId());
        }
        return autoGroupResponse;
    }

    @GetMapping("/initrequest/{id}")
    public AutoGroupData searchAutoGroupDataById(@PathVariable("id") String id)
    {
        AutoGroupData autoGroupData = autoGroupDataService.getAllAutoGroupDataForId(id);

        return autoGroupData;
    }

    @GetMapping("/{id}")
    public AutoGroupResponse searchAutoGroupResponseById(@PathVariable("id") String id)
    {
        AutoGroupResponse autoGroupResponse = autoGroupResponseService.getAllAutoGroupResponseForId(id);

        return autoGroupResponse;
    }

    @PostMapping("/sample-request")
    public AutoGroupData addAutoGroupDataSample(@RequestBody AutoGroupData autoGroupData)
    {
        return autoGroupDataService.createAutoGroupDataIndex(autoGroupData);
    }

    @PostMapping("/sample-response")
    public AutoGroupResponse createAutoGroupResponseSample(@RequestBody AutoGroupResponse autoGroupResponse)
    {
        autoGroupResponseService.createAutoGroupResponseIndex(autoGroupResponse);
        return autoGroupResponse;
    }

    @GetMapping("async/{num}")
    public String asyncCallerMethod(@PathVariable("num") String num) {
        long start = System.currentTimeMillis();
        autoGroupDataService.getAllAutoGroupDataForId(num);
        String response = "task completes in :" +
                (start -   System.currentTimeMillis()) + "milliseconds";
        return response;
    }
}
