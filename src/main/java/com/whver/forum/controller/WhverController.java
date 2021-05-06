package com.whver.forum.controller;

import com.whver.forum.pojo.Whver;
import com.whver.forum.service.WhverService;
import com.whver.forum.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class WhverController {

    @Autowired
    WhverService whverService;

    @RequestMapping("/whvers")
    public Object list(@RequestParam(defaultValue = "0") int start,
                       @RequestParam(defaultValue = "6") int size) {
        // make the start is always equals or greater than 0
        start = start < 0 ? 0 :start;
        return Result.success(whverService.list(start, size));
    }

    @GetMapping("/whvers/{id}")
    public Object get(@PathVariable int id) {
        Whver whver = whverService.get(id);
        return Result.success(whver);
    }

    @PutMapping("/whvers")
    public Object update(Whver whver) {
        whverService.update(whver);
        return Result.success(null);
    }

    @PostMapping("/whvers")
    public Object add(Whver whver) {
        whver.setCreateTime(new Date());
        whverService.add(whver);
        return Result.success(null);
    }


}
