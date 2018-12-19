package com.springboot.log4j2.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Created by liuxun on 2017/4/13.
 */
@Component
public class TestService {
    private static final Logger LOGGER = LogManager.getLogger(TestService.class.getName());
    public void testLog(){
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