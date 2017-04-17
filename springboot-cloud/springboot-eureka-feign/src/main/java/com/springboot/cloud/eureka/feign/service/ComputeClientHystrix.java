package com.springboot.cloud.eureka.feign.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Hystrix断路器
 * Hystrix是Netflix开源的微服务框架套件之一，
 * 该框架目标在于通过控制那些访问远程系统、服务和第三方库的节点，从而对延迟和故障提供更强大的容错能力。
 * Hystrix具备拥有回退机制和断路器功能的线程和信号隔离，请求缓存和请求打包，以及监控和配置等功能。
 * Created by liuxun on 2017/4/17.
 */
@Component
public class ComputeClientHystrix implements ConsumerClient {
    @Override
    public String addClient(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return "0";
    }

    @Override
    public String subtractClient(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return "-999";
    }
}
