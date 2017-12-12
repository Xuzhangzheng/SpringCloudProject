package com.xiduoduo.core.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/11/30.
 */
@Component
@Scope(value = "prototype")
public class Properties {

    @Value("${fliterFlag.pre}")
    public Integer fliterFlag_pre ;

    @Value("${fliterFlag.route}")
    public Integer fliterFlag_route ;

    @Value("${fliterFlag.post}")
    public Integer fliterFlag_post ;

    @Value("${fliterFlag.error}")
    public Integer fliterFlag_error ;
}
