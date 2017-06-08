package com.springboot.lombok;

import com.springboot.lombok.domain.User;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LiuXun on 2017/3/18.
 */

@Controller
@Log4j2
public class Hello{

    @RequestMapping("/hello")
    @ResponseBody
    public User hello(){
        User user=new User();
        user.setAge(1);
        user.setName("asdf");
        user.setId(1L);
        user.getUserInfo(0L);
        log.info(user.toString());
        return user;
    }

}
