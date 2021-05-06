package com.whver.forum.service;

import com.whver.forum.dao.JobDAO;
import com.whver.forum.pojo.Job;
import com.whver.forum.utils.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    JobDAO jobDAO;

    public Job get(int id) {
        return jobDAO.getOne(id);
    }

    public Page4Navigator<Job> listByCountryId(int start, int size, int cid) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);
        Page<Job> pageFromJPA = jobDAO.findByCountryId(pageable, cid);
        return new Page4Navigator<>(pageFromJPA);
    }

    public Page4Navigator<Job> listByStateId(int start, int size, int sid) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);
        Page<Job> pageFromJPA = jobDAO.findByStateId(pageable, sid);
        return new Page4Navigator<>(pageFromJPA);
    }

}
