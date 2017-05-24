package org.springboot.mybatis.demo.action;

import com.alibaba.fastjson.JSON;
import org.springboot.mybatis.domain.Info;
import org.springboot.mybatis.service.InfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LiuXun on 2017/3/18.
 */
@Controller
public class Hello {
    @Resource
    private InfoService infoService;
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        
        List<Info> list = infoService.getAll();
        String json = JSON.toJSONString(list);
        return json;
    }

}
