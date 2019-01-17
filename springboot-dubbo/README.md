springboot2.0+dubbo+zk集成
----------------------------
1、安装zookeeper
https://blog.csdn.net/qi49125/article/details/60779877
#启动zk
sh bin/zkServer.sh start-foreground
2、引入dubbo-starter
 <dependency>
    <groupId>com.alibaba.boot</groupId>
    <artifactId>dubbo-spring-boot-starter</artifactId>
    <version>0.2.0</version>
</dependency>
<dependency>
    <groupId>org.apache.zookeeper</groupId>
    <artifactId>zookeeper</artifactId>
    <version>${zookeeper.version}</version>
</dependency>