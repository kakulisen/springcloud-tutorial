package com.eurekafeignclient.pojo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient
public interface DcClient {

    @GetMapping("/dc")
    String consumer();
}
