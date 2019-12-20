package com.springboot.mybatisplus.doman;

import lombok.Data;

import java.util.Date;

/**
 * @author xun2.liu
 * @title: User
 * @projectName springboot-project
 * @description: User
 * @date 2019/12/19 19:51
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Date createTime;
}
