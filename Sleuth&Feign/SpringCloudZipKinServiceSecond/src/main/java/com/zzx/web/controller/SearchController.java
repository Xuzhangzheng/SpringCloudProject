package com.zzx.web.controller;

import com.zzx.core.server.DealwithService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/12/7.
 */
@RestController
@RequestMapping(value = "search")
public class SearchController {

    @Resource
    DealwithService dealwithService ;

    @RequestMapping(value="/searchList",method= {RequestMethod.GET})
    public String searchList(@RequestParam String params){
        params = params + "[service-second]" ;
        return dealwithService.getMessageList(params) ;
    }

}
