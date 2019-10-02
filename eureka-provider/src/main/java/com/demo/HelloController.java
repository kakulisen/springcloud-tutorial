package com.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class HelloController {

  @RequestMapping("hello/{name}")
  public String hello(@PathVariable String name){
    return "Hello, " + name;
  }

}
