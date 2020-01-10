package com.springboot.cache.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by liuxun on 2017/4/13.
 */
@Component
public class TestService {
    private static final Logger LOGGER = LogManager.getLogger(TestService.class.getName());
    @Autowired
    private RedisUtil redisUtil;
    public void testLog(){
        long b=System.currentTimeMillis();
        LOGGER.info("{}日志内容",b);
    }

    /**
     * reidis互斥锁
     */
    public String getProductByRedis() {
        //分布式锁key
        String key="product:lock";
        //商品信息
        String productKey="product.item";
        try {
            String productInfo=redisUtil.get(productKey);
            if (StringUtils.isNotBlank(productInfo)){
                return productInfo;
            }
            if (redisUtil.setIfAbsent(key,"1",10, TimeUnit.SECONDS)){
                //拿到锁,模拟从数据中查询到数据然后回写缓存
                String val="apple";
                redisUtil.setEx(productKey,val,10,TimeUnit.SECONDS);
                return val;
            }else{
                //没拿到锁。就等待。然后直到拿到数据为止
                TimeUnit.SECONDS.sleep(100);
                getProductByRedis();
            }
        } catch (Exception e) {
            LOGGER.error("获取商品信息失败",e);
        }
        return null;
    }

}