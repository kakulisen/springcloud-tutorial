package com.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscoveryController {

  @Autowired
  DiscoveryClient discoveryClient;

  @GetMapping("/services")
  public List<String> services(){
    return discoveryClient.getServices();
  }

  @GetMapping("/services/{name}")
  public List<ServiceInstance> service(@PathVariable("name") String name){
    return discoveryClient.getInstances(name);
  }

}
