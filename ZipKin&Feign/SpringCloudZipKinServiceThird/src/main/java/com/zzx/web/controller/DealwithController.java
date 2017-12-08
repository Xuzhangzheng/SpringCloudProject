package com.zzx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/12/7.
 */
@RestController
@RequestMapping(value = "dealwith")
public class DealwithController {

    @RequestMapping(value="/getMessageList",method= {RequestMethod.GET})
    public String getMessageList(@RequestParam String params){
        return params+"[service-third]" ;
    }
}
