package com.springboot.profile.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
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
        List<Map> list=new ArrayList();
        for (int i=0;i<20;i++){
            Map map=new HashMap();
            map.put(i,"adfasdf"+i);
            list.add(map);
        }
        return "hello boot";
    }
}
