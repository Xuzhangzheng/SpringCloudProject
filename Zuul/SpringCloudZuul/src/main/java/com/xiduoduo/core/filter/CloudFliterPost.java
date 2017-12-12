package com.xiduoduo.core.filter;

import com.netflix.zuul.ZuulFilter;
import com.xiduoduo.core.utils.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/11/30.
 */
@Component
public class CloudFliterPost extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(CloudFliterPost.class) ;

    @Autowired
    Properties properties ;

    /*
    filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
        pre：路由之前
        routing：路由之时
        post： 路由之后
        error：发送错误调用
     */
    @Override
    public String filterType() {
        return "post";
    }

    /*
    filterOrder：过滤的顺序
    序号越小优先级越高
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /*
    shouldFilter：这里可以写逻辑判断，是否要过滤。
    true：过滤
    false：不过滤
     */
    @Override
    public boolean shouldFilter() {
        // 通过配置决定过滤器是否生效
        if(1==properties.fliterFlag_post) {
            return true;
        }
        return false ;
    }

    /*
    run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     */
    @Override
    public Object run() {
        logger.info("post filter is running");
        return null;
    }
}
