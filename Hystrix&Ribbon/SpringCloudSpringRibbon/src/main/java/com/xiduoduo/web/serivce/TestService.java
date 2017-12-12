package com.xiduoduo.web.serivce;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/11/28.
 */
@Service
public class TestService {

    @Resource
    RestTemplate restTemplate ;

    // 使用restTemplate.getForObject方法，访问服务名为service-clientOne的服务的方法
    // 并且在调用的工程中需要写服务的名，而不是具体的ip，就像此处的service-clientOne
    // *********************************************
    // 断路器 start
    // *********************************************
    @HystrixCommand(fallbackMethod="testRibbonServiceError")
    public String testRibbonService(String clientName) {
        return restTemplate.getForObject("http://service-client/test/testMethod?params="+clientName,String.class) ;
    }

    public String testRibbonServiceError(String clientName) {
        return "testRibbonService error , clientName : "+ clientName ;
    }
    // *********************************************
    // 断路器 end
    // *********************************************


}
