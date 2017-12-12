package com.xiduoduo.core.fallback;

import com.xiduoduo.web.serivce.TestService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/11/29.
 */
@Component
public class FeignClientFallBackFactoryImpl implements FallbackFactory<TestService> {

    @Override
    public TestService create(Throwable throwable) {
        return new TestService() {
            @Override
            public String testFeignService(@RequestParam(value = "params") String params) {
                return "FallBackFactory testFeignService error";
            }

            @Override
            public String testFeignServiceGet(@RequestParam("params") String params) {
                return "FallBackFactory testFeignServiceGet error";
            }

            @Override
            public String testFeignServicePost(@RequestBody String params) {
                return "FallBackFactory testFeignServicePost error";
            }

            @Override
            public String testFeignServiceHead(@RequestHeader("params") String params) {
                return "FallBackFactory testFeignServiceHead error";
            }
        } ;
    }

}
