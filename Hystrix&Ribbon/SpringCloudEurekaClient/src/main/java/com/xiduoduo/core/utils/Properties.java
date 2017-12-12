package com.xiduoduo.core.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/11/28.
 */
@Component
@Scope(value = "prototype")
public class Properties {

    @Value("${server.port}")
    public String serverPort ;
}
