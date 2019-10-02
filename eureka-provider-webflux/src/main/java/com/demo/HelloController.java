package com.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/provider-webflux")
public class HelloController {

  @RequestMapping("hello/{name}")
  public Mono<String> hello(@PathVariable String name) {
    return Mono.just("Welcome to reactive world ~, " + name);
  }
}
