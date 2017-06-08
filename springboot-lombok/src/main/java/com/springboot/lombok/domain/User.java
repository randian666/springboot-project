package com.springboot.lombok.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import java.util.ArrayList;

/**
 * Created by liuxun on 2017/6/8.
 */
@Data  //生成get、set、equals、canEqual、hashCode、toString
@NoArgsConstructor  //无参构造方法
@AllArgsConstructor //有参数的构造方法
@Log4j2
public class User {
    private long id;
    private String name;
    private int age;

    @Setter(AccessLevel.PROTECTED)//生成get方法 并设置方法访问范围
    @Getter(AccessLevel.PROTECTED)//生成set方法 并设置方法访问范围
    private String sex;

    /**
     * NonNull非空校验
     * 相当于
     * if (id == null) {
     *     throw new NullPointerException("id");
     *}
     * @param id
     * @return
     */

    public String getUserInfo(@NonNull Long id){
        log.info("此用户的ID是{}",id);
        return "此用户的ID是："+id;
    }
    /**
     * val定义final变量
     * final ArrayList<String> example = new ArrayList<String>();
     * @return
     */
    public String example() {
        val example = new ArrayList<String>();
        example.add("Hello, World!");
        val foo = example.get(0);
        return foo.toLowerCase();
    }
}
