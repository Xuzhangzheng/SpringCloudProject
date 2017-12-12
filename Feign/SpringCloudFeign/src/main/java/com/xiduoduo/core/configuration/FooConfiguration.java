package com.xiduoduo.core.configuration;

import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/11/28.
 */
//@Configuration
public class FooConfiguration {

    //@Bean
    public Contract feignContract() {
        return new feign.Contract.Default() ;
    }

    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user","password") ;
    }
}
