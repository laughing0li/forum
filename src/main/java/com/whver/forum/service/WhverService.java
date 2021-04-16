package com.whver.forum.service;

import com.whver.forum.dao.WhverDAO;
import com.whver.forum.pojo.Whver;
import com.whver.forum.utils.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class WhverService {

    @Autowired
    WhverDAO whverDAO;

    public Whver get(int id) {
        return whverDAO.getOne(id);
    }

    public void add(Whver whver) {
        whverDAO.save(whver);
    }

    public void update(Whver whver) {
        whverDAO.save(whver);
    }

    public Page4Navigator<Whver> list(int start, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, size, sort);
        Page<Whver> pageFromJPA = whverDAO.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA);
    }
}
