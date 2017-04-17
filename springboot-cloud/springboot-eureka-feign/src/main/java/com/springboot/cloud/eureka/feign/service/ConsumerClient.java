package com.springboot.cloud.eureka.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by liuxun on 2017/4/17.
 */
@FeignClient("compute-service")
public interface ConsumerClient {

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    String test(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
}
