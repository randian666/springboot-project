package com.springboot.mybatisplus.test;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.springboot.mybatisplus.doman.User;
import com.springboot.mybatisplus.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author xun2.liu
 * @title: SelectTest
 * @projectName springboot-project
 * @description: mybatisplus测试
 * @date 2019/12/19 19:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询全部数据
     */
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        QueryWrapper<User> query=new QueryWrapper<>();
        List<User> userList = userMapper.selectList(query);
        Assert.assertTrue(userList.size()>0);
        userList.forEach(System.out::println);
    }
    /**
     * 通过条件查询
     */
    @Test
    public void testSelectByMap() {
        System.out.println(("----- testSelectByMap method test ------"));
        Map<String, Object> queryMap=new HashMap<>();
        queryMap.put("age",18);
        List<User> userList = userMapper.selectByMap(queryMap);
        userList.forEach(System.out::println);
    }
    /**
     * 通过条件查询
     */
    @Test
    public void testSelectByQueryWrapper() {
        System.out.println(("----- testSelectByQueryWrapper method test ------"));
        //name like "J" and age between 12 and 20 and email is not null
        QueryWrapper<User> query=new QueryWrapper<>();
        query.like("name","J")
                .between("age",12,30)
                .isNotNull("email")
                .orderByDesc("id");
        List<User> userList = userMapper.selectList(query);
        userList.forEach(System.out::println);
    }

    /**
     * 通过条件查询
     */
    @Test
    public void testSelectByQueryWrapper2() {
        System.out.println(("----- testSelectByQueryWrapper2 method test ------"));
        //DATE_FORMAT(create_time,'%Y-%m-%d')=? and age in (select age from user where name like '张%')
        QueryWrapper<User> query=new QueryWrapper<>();
        //使用占位符可以防止sql注入
        query.apply("DATE_FORMAT(create_time,'%Y-%m-%d')={0}","2019-12-09")
             .inSql("age","select age from user where name like '张%'");
        List<User> userList = userMapper.selectList(query);
        userList.forEach(System.out::println);
    }

    /**
     * 通过条件查询
     */
    @Test
    public void testSelectByQueryWrapper3() {
        System.out.println(("----- testSelectByQueryWrapper3 method test ------"));
        //name like '张%' or (age>12 and age<30 and email is not null)
//        QueryWrapper<User> query=new QueryWrapper<>();
//        query.likeRight("name","张")
//             .or(wq->wq.ge("age",12).le("age",30).isNotNull("email"));

        //(age>12 and age<30 and email is not null) and name like '张%'
        QueryWrapper<User> query=new QueryWrapper<>();
        query.nested(wq->wq.ge("age",12).le("age",30).isNotNull("email"))
                .likeRight("name","张");
        List<User> userList = userMapper.selectList(query);
        userList.forEach(System.out::println);
    }

    /**
     * 通过条件查询
     */
    @Test
    public void testSelectByQueryWrapper4() {
        System.out.println(("----- testSelectByQueryWrapper4 method test ------"));
        //age in (12,13,30)
        QueryWrapper<User> query=new QueryWrapper<>();
        query.in("age", Arrays.asList(12,20,30));
        List<User> userList = userMapper.selectList(query);
        userList.forEach(System.out::println);
    }

    /**
     * 通过条件查询
     * 指定字段
     */
    @Test
    public void testSelectByQueryWrapper5() {
        System.out.println(("----- testSelectByQueryWrapper5 method test ------"));
        QueryWrapper<User> query=new QueryWrapper<>();
        query.select("id","name").in("age", Arrays.asList(12,20,30));
        List<User> userList = userMapper.selectList(query);
        userList.forEach(System.out::println);
    }
}
