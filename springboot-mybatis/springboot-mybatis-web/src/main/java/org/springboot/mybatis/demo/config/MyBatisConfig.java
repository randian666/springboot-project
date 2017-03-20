package org.springboot.mybatis.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * Created by LiuXun on 2017/3/18.
 */
@Configuration
@MapperScan("org.springboot.mybatis.mapper")// mapper 接口类扫描包配置
@ComponentScan(value = "org.springboot")//注解扫描
public class MyBatisConfig {

}
