package com.springboot.thymeleaf.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

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


    @RequestMapping("/helloThy")
    public String helloThy(Map<String,Object> map){
        map.put("hello","from TemplateController.helloHtml");
        return"/hello";
    }
}
