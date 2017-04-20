package com.springboot.cloud.eureka.feign.action;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.springboot.cloud.eureka.feign.service.ConsumerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 *
 * Created by liuxun on 2017/4/17.
 */
@RestController
public class ConsumerController {
    @Autowired
    ConsumerClient computeClient;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/testAdd", method = RequestMethod.GET)
    public String testAdd(@RequestParam Integer a, @RequestParam Integer b) {
        return computeClient.addClient(a,b);
    }
    @RequestMapping(value = "/testSubtract", method = RequestMethod.GET)
    public String testSubtract(@RequestParam Integer a, @RequestParam Integer b) {
        return computeClient.subtractClient(a,b);
    }

    /**
     * discoveryClient方式消费
     * @return
     */
    @RequestMapping(value = "/testDiscovery", method = RequestMethod.GET)
    public String testDiscovery() {
        List<ServiceInstance> list = discoveryClient.getInstances("compute-service");
        if (list != null && list.size() > 0 ) {
            URI uri = list.get(0).getUri();
            if (uri !=null ) {
                 return (new RestTemplate()).getForObject(uri+"/subtract?a=1&b=1",String.class);
            }
        }
        return "";
    }
}
