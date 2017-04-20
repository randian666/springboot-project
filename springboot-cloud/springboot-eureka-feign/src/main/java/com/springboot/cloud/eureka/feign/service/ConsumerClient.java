package com.springboot.cloud.eureka.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 消费者服务
 * Created by liuxun on 2017/4/17.
 */
@FeignClient(value = "${spring.application.topic}",fallback = ComputeClientHystrix.class)
public interface ConsumerClient {

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    String addClient(@RequestParam("a") Integer a, @RequestParam("b") Integer b);


    @RequestMapping(method = RequestMethod.GET, value = "/subtract")
    String subtractClient(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
}
