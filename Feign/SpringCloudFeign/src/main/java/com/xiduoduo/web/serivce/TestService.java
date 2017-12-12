package com.xiduoduo.web.serivce;

import com.xiduoduo.core.configuration.FooConfiguration;
import com.xiduoduo.core.fallback.FeignClientFallBackFactoryImpl;
import com.xiduoduo.core.fallback.HystrixClientFallBack;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/11/28.
 */
// FeignClient 中的value用于指定访问的是哪一个服务的方法
// 该注解只能用于类上
// name指定了注册到Eureka上的服务名
// value指定了注册到Eureka上的服务名
// |--在指定注册到EureKa上的服务名时，除了使用name外，还可以使用value进行执行，name与value起到的作用是一样的
// |--若同时设置了name和value的话，在虚拟机启动程序的时候，会出现AnnotationConfigurationException异常，
// |--并提示：attribute 'name' and its alias 'value' are declared with values of [a] and [b], but only one is permitted.
// |--意思为name是value的别名，这二者中只允许使用一个
// configuration 可以重写feign的配置，详情参考：http://projects.spring.io/spring-cloud/spring-cloud.html#spring-cloud-feign
// fallback 是服务降级后的接口实现类：需在配置文件中开启熔断开关，配置为：feign.hystrix.enabled=true
// fallbackFactory
// |-- 当fallback 和 fallbackFactory 并存的时候，始终使用的是fallback指定的类，当仅有fallbackFactory时 ， 指定的类才会生效
// TODO 存在疑问点，fallback 与 fallbackFactory 优先级的问题，另外区别、具体含义、使用场景需要看一下
@FeignClient(
        name = "service-client"
        //, value = "service-client"
        //,configuration = FooConfiguration.class
        ,fallbackFactory = FeignClientFallBackFactoryImpl.class
        //,fallback = HystrixClientFallBack.class
        )
public interface TestService {
    // RequestMapping 注解 用于请求指定名称服务的指定方法
    // 同时在传递参数时，可以使用@RequestParam注解将指定参数值设置为value值对应的参数名称的值，value中的值为指定服务的指定方法的参数名称
    // 注意：不使用@RequestParam注解的话，无法实现参数的传递
    @RequestMapping(value = "/test/testMethod" , method = {RequestMethod.GET})
    public String testFeignService(@RequestParam(value = "params") String params) ;

    //@RequestLine("GET /test/testMethod")
    //public String testFeignService(@RequestParam(value = "params") String params) ;

    /*
    ================================================

    ================================================
     */

    @RequestMapping(value="/test/testFeignMethodGet",method= {RequestMethod.GET})
    String testFeignServiceGet(@RequestParam("params") String params);

    @RequestMapping(value="/test/testFeignMethodPost", method=RequestMethod.POST)
    String testFeignServicePost(@RequestBody String params);

    @RequestMapping(value="/test/testFeignMethodHead", method=RequestMethod.HEAD)
    String testFeignServiceHead(@RequestHeader("params") String params);


}
