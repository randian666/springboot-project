package com.springboot.cloud.eureka.feign.action;

import com.springboot.cloud.eureka.feign.service.ConsumerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuxun on 2017/4/17.
 */
@RestController
public class ConsumerController {
    @Autowired
    ConsumerClient computeClient;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(@RequestParam Integer a, @RequestParam Integer b) {
        return computeClient.test(a,b);
    }

}
