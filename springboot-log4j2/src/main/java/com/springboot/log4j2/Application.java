package com.springboot.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer{
	private static final Logger LOGGER = LogManager.getLogger(Application.class.getName());
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	public static void main(String[] args) {
		LOGGER.error("Application begining");
		SpringApplication.run(Application.class, args);
		LOGGER.error("Application ending");
		long b=System.currentTimeMillis();
		for(int i=1;i<=200000;i++){
			if (i==200000){
				LOGGER.info("开始{}日志内容,耗时{}",i,(System.currentTimeMillis()-b));
			}else{
				LOGGER.info("开始{}日志内容",i);
			}
		}
	}
}
