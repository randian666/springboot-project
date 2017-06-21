package com.springboot.freemarker.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

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

    @RequestMapping("/freemarker")
    public String welcome(ModelMap model) {
        model.put("time", new Date());
        model.put("message", "hello freemarker");
        return "hello";
    }
}
