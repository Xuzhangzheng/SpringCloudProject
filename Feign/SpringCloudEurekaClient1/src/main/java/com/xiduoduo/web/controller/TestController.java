package com.xiduoduo.web.controller;

import com.xiduoduo.core.utils.Properties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/11/28.
 */
@RestController
@RequestMapping(value = "test")
public class TestController {

    @Resource
    Properties properties ;

    @RequestMapping(value = "/testMethod" , method = {RequestMethod.GET,RequestMethod.POST})
    public String testMethod( String params ) {
        return "current request method is get & post , this client port is :"+ properties.serverPort +", request params is :"+ params ;
    }

    @RequestMapping(value = "/testFeignMethodGet" , method = {RequestMethod.GET})
    public String testFeignMethod(@RequestParam String params ) {
        return "current request method is get , this client port is :"+ properties.serverPort +", request params is :"+ params ;
    }

    @RequestMapping(value = "/testFeignMethodPost" , method = {RequestMethod.POST})
    public String testFeignMethodPost(@RequestBody String params ) {
        return "current request method is post , this client port is :"+ properties.serverPort +", request params is :"+ params ;
    }

    @RequestMapping(value = "/testFeignMethodHead" , method = {RequestMethod.HEAD})
    public String testFeignMethodHead(@RequestHeader String params ) {
        return "current request method is head , this client port is :"+ properties.serverPort +", request params is :"+ params ;
    }
}
