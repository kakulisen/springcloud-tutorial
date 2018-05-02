package com.cloud.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class EurekaClientApplication {


    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    @GetMapping("/dcWithTimeOut")
    public String dcWithTimeOut() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return services;
    }



    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }


}
