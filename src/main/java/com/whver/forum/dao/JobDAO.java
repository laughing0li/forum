package com.whver.forum.dao;

import com.whver.forum.pojo.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDAO extends JpaRepository<Job, Integer> {
    // 根据国家来进行筛选
    Page<Job> findByCountryId(Pageable pageable, int id);
    // 根据州来筛选

    Page<Job> findByStateId(Pageable pageable, int id);
}
