package com.springboot.swagger.action;


import com.springboot.swagger.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * RESTful 风格接口
 * Created by liuxun on 2017/3/21.
 */
@Controller
@RequestMapping(value="/users")     // 通过这里配置使下面的映射都在/users下，可去除
public class UserController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());
    static {
        User u=new User();
        u.setId(1L);
        u.setName("刘勋");
        users.put(1L,u);
    }
    @ApiOperation(value="普通url接口测试", notes="普通url接口测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String",paramType = "query")
    })
    @RequestMapping(value = "/hello",method=RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam String name){
        return "hello boot"+name;
    }

    @ApiOperation(value="RESTFUL获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "long",paramType = "path"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "int",paramType = "path")
    })
    @RequestMapping(value="/{id}/{age}", method=RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable Long id,@PathVariable Integer age) {
        User u = users.get(id);
        u.setAge(age);
        return u;
    }
}