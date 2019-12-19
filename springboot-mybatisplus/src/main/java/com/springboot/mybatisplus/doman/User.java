package com.springboot.mybatisplus.doman;

import lombok.Data;

/**
 * @author xun2.liu
 * @title: User
 * @projectName springboot-project
 * @description: TODO
 * @date 2019/12/19 19:51
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
