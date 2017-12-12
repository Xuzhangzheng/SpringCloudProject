package com.xiduoduo.web.controller;

import com.xiduoduo.core.utils.Properties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/11/28.
 */
@Controller
@RequestMapping(value = "test")
public class TestController {

    @Resource
    Properties properties ;

    @ResponseBody
    @RequestMapping(value = "/testMethod" , method = {RequestMethod.GET,RequestMethod.POST})
    public String testMethod( String params ) {
        return "current request method is get & post , this client port is :"+ properties.serverPort +", request params is :"+ params ;
    }

}
