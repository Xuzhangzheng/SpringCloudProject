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
@RequestMapping(value = "ribbonTest")
public class TestController {

    @Resource
    TestService testService ;

    @ResponseBody
    @RequestMapping(value = "getRequestClientName")
    public String testResultClientName(String clientName) {
        return testService.testRibbonService(clientName) ;
    }
}
