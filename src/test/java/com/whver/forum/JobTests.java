package com.whver.forum;

import com.whver.forum.controller.JobController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class JobTests {

    @Autowired
    JobController jobController;

    @Transactional
    @Test
    public void listCountryJobs() {
        Object o = jobController.listByCountry(1, 0, 5);
        System.out.println(o);
    }

    @Transactional
    @Test
    public void listStateJobs() {
        Object o = jobController.listByState(1, 0, 5);
        System.out.println(o);
    }

}
