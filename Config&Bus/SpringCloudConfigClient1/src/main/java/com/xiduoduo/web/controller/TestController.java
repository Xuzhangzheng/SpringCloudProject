package com.xiduoduo.web.controller;

import com.xiduoduo.core.utils.Properties ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/1.
 */
@RestController
public class TestController {

    @Autowired
    private Properties properties ;

    @RequestMapping(value = "testConfig")
    @ResponseBody
    public String testConfig() {
        return properties.getFliterFlag_post()+"" ;
    }
}
