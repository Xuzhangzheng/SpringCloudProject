package com.zzx.web.controller;

import com.zzx.core.server.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/12/7.
 */
@Controller
public class ZipKinController {

    @Resource
    SearchService searchService ;

    @RequestMapping(value = "zipKinMethod" , method = {RequestMethod.GET})
    @ResponseBody
    public String zipKinMethod(String params) {
        return searchService.searchList(params) ;
    }
}
