package com.eurekafeignclient.controller;

import com.eurekafeignclient.pojo.HelloClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

    @Autowired
    HelloClient helloClient;

    @Autowired
    DiscoveryClient discoveryClient;


    @GetMapping("/consumer")
    public String dc() {
        return helloClient.hello("world");
    }

    @GetMapping("/services")
    public List<String> services() {
        return discoveryClient.getServices();
    }
}
