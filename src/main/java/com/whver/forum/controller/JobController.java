package com.whver.forum.controller;


import com.whver.forum.service.JobService;
import com.whver.forum.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
    @Autowired
    JobService jobService;

    @GetMapping("/{cid}/jobs")
    public Object listByCountry(@PathVariable int cid,
                                @RequestParam(defaultValue = "0") int start,
                                @RequestParam(defaultValue = "6") int size) {
        start = start < 0 ? 0 :start;
        return Result.success(jobService.listByCountryId(start, size, cid));
    }

    @GetMapping("/{sid}/jobs")
    public Object listByState(@PathVariable int sid,
                              @RequestParam(defaultValue = "0") int start,
                              @RequestParam(defaultValue = "6") int size){
        start = start < 0 ? 0 :start;
        return Result.success(jobService.listByStateId(start, size, sid));
    }

}
