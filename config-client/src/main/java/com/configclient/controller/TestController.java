package com.configclient.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {



    @Value("${info.profile}")
    public String info;

    @RequestMapping("/info1")
    public String info1() {
        return info;
    }

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }


}
