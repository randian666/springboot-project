package com.springboot.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author xun2.liu
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	private final static Logger logger = LoggerFactory.getLogger(Application.class);
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	public static void main(String[] args) {
		logger.info("Application begining");
		SpringApplication.run(Application.class, args);
		logger.info("Application ending");
	}
}
