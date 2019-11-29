package com.ywf.srpingbootproject.controller;

import com.ywf.srpingbootproject.annotation.DoneTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/testError")
    public String testError() {
        Map map = null;
        return map.toString();
    }

    @RequestMapping("/testDoneTime")
    @DoneTime("IndexController")
    public String testDoneTime() {
        return "doneTime";
    }
}
