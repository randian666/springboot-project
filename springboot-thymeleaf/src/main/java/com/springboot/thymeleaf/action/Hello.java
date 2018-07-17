package com.springboot.thymeleaf.action;

import com.springboot.thymeleaf.bean.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        List<String> list=new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        map.put("listIds",list);
        User u=new User();
        u.setId(1);
//        u.setAge(12);
        u.setName("刘勋");
        u.setRemark("hello boot");
        map.put("user",u);
        map.put("currDate",new Date());
        return"/hello";
    }
}
