package com.springboot.swagger.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LiuXun on 2017/3/18.
 */
@Controller
public class Hello {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello boot";
    }
}
