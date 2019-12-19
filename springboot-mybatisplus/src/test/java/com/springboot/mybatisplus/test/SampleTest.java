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

import java.util.List;

/**
 * @author xun2.liu
 * @title: SampleTest
 * @projectName springboot-project
 * @description: TODO
 * @date 2019/12/19 19:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
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
        Assert.assertEquals(5, userList.size());
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
                .between("age",12,18)
                .isNotNull("email");
        List<User> userList = userMapper.selectList(query);
        userList.forEach(System.out::println);
    }
}
