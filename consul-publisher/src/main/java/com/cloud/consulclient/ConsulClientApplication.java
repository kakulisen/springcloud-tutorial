package com.cloud.consulclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ConsulClientApplication {


    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() {

        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }



    public static void main(String[] args) {
        SpringApplication.run(ConsulClientApplication.class, args);
    }
}
