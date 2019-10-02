package com.eurekafeignclient.pojo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "eureka-PROVIDER")
@RequestMapping("/provider")
public interface HelloClient {

  @RequestMapping("hello/{name}")
  String hello(@PathVariable("name") String name);
}
