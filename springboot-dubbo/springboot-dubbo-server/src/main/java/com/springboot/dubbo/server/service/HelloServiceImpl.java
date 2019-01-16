package com.springboot.dubbo.server.service;

import com.springboot.dubbo.service.HelloService;

/**
 * @Author: liuxun
 * @CreateDate: 2019/1/16 下午7:57
 * @Version: 1.0
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello "+ name;
    }
}
