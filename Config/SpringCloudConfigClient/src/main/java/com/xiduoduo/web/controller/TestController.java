package com.xiduoduo.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/1.
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${fliterFlag.post}")
    public Integer fliterFlag_post ;

    @RequestMapping(value = "testConfig")
    @ResponseBody
    public String testConfig() {
        return fliterFlag_post+"" ;
    }
}
