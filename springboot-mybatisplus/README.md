# Spring Boot 与MybatisPlus集成

+ 1、安装
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <version>3.3.0</version>
    </dependency>
引入 MyBatis-Plus 之后请不要再次引入 MyBatis 以及 MyBatis-Spring，以避免因版本差异导致的问题。

+ 2、springboot配置
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")


参考：
https://mp.baomidou.com/




