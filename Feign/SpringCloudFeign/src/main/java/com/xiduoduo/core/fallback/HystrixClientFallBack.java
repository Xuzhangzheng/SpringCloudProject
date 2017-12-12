package com.xiduoduo.core.fallback;

import com.xiduoduo.web.serivce.TestService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/11/29.
 */
@Component
public class HystrixClientFallBack implements TestService {
    @Override
    public String testFeignService(@RequestParam(value = "params") String params) {
        return "testFeignService error";
    }

    @Override
    public String testFeignServiceGet(@RequestParam("params") String params) {
        return "testFeignServiceGet error";
    }

    @Override
    public String testFeignServicePost(@RequestBody String params) {
        return "testFeignServicePost error";
    }

    @Override
    public String testFeignServiceHead(@RequestHeader("params") String params) {
        return "testFeignServiceHead error";
    }
}
