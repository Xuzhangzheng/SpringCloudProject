package com.xiduoduo.core.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/11/30.
 */
@Component
@Scope(value = "prototype")
@RefreshScope
public class Properties {

    @Value("${fliterFlag.post}")
    public Integer fliterFlag_post ;

    public Integer getFliterFlag_post() {
        return fliterFlag_post;
    }

    public void setFliterFlag_post(Integer fliterFlag_post) {
        this.fliterFlag_post = fliterFlag_post;
    }
}
