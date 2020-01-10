package com.springboot.cache.action;

import com.springboot.cache.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by LiuXun on 2017/3/18.
 */
@Controller
public class Hello {
    @Resource
    private TestService testService;
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        testService.testLog();
        return "hello boot";
    }
}
