package com.whver.forum.controller;

import com.whver.forum.service.WhverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhverController {

    @Autowired
    WhverService whverService;

}
