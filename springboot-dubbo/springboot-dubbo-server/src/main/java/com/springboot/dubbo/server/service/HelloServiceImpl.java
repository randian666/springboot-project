package com.springboot.dubbo.server.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.springboot.dubbo.service.HelloService;

/**
 * @Author: liuxun
 * @CreateDate: 2019/1/16 下午7:57
 * @Version: 1.0
 */
@Service(version = "1.0.0")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello "+ name;
    }
}
