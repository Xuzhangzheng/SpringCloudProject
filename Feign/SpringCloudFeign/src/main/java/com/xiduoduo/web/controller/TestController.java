package com.xiduoduo.web.controller;

import com.xiduoduo.web.serivce.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/11/28.
 */
@Controller
@RequestMapping(value = "feignTest")
public class TestController {

    @Resource
    TestService testService ;

    @ResponseBody
    @RequestMapping(value = "testResultClientName")
    public String testResultClientName(String method , String clientName) {
        switch (method){
            case "get":
            case "Get":
            case "GET":
                return testService.testFeignServiceGet(clientName) ;
            case "post":
            case "Post":
            case "POST":
                return testService.testFeignServicePost(clientName) ;
            case "head":
            case "Head":
            case "HEAD":
                return testService.testFeignServiceHead(clientName) ;
            default:
                return testService.testFeignService(clientName) ;
        }
    }

}
