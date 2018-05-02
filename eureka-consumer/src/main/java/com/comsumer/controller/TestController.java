package com.comsumer.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class TestController {

    @Autowired
    LoadBalancerClient loadBalancerClient;


    @Autowired
    RestTemplate restTemplate;


    @Autowired
    AsyncRestTemplate asyncRestTemplate;


    @GetMapping("/consumer3")
    public String comsumer3(){

        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");

        return restTemplate.getForObject("http://eureka-client/dc", String.class);

    }


    @GetMapping("/consumer")
    public String comsumer(){


        UriComponents uriComponents = UriComponentsBuilder.fromUriString(
                "http://example.com/hotels/{hotel}/bookings/{booking}").build()
                .expand("42", "21")
                .encode();
        URI uri = uriComponents.toUri();


        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");

        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/dc";

        return restTemplate.getForObject(url,String.class);
    }


    @GetMapping("/consumer2")
    public String comsumer2(){


        // async call
        Future<ResponseEntity<String>> futureEntity = asyncRestTemplate.getForEntity(
                "http://example.com/hotels/{hotel}/bookings/{booking}", String.class, "42", "21");

        // get the concrete result - synchronous call
        try {


            ResponseEntity<String> entity = futureEntity.get();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;

    }




}
