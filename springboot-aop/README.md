### 引入AOP依赖
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>



### 实现Web层的日志切面
实现AOP的切面主要有以下几个要素：

使用@Aspect注解将一个java类定义为切面类
使用@Pointcut定义一个切入点，可以是一个规则表达式，比如下例中某个package下的所有函数，也可以是一个注解等。
根据需要在切入点不同位置的切入内容
使用@Before在切入点开始处切入内容
使用@After在切入点结尾处切入内容
使用@AfterReturning在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
使用@Around在切入点前后切入内容，并自己控制何时执行切入点自身的内容
使用@AfterThrowing用来处理当切入内容部分抛出异常之后的处理逻辑