package com.xiduoduo.core.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.xiduoduo.core.utils.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/11/30.
 */
@Component
public class CloudFliterPreLow extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(CloudFliterPreLow.class) ;

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
        return "pre";
    }

    /*
    filterOrder：过滤的顺序
    序号越小优先级越高
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /*
    shouldFilter：这里可以写逻辑判断，是否要过滤。
    true：过滤
    false：不过滤
     */
    @Override
    public boolean shouldFilter() {
        // 通过配置决定过滤器是否生效
        if(1==properties.fliterFlag_pre) {
            return true;
        }
        return false ;
    }

    /*
    run：过滤器的具体逻辑。
    可以编写业务逻辑，包括查sql，nosql去判断该请求到底有没有权限访问。
     */
    @Override
    public Object run() {
        logger.info("low pre filter is running");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        if(request.getRequestURI().indexOf("api-b")!=-1) {
            String method = request.getParameter("method") ;
            if(StringUtils.isEmpty(method)) {
                logger.warn("method is empty");
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(401);
                try {
                    ctx.getResponse().getWriter().write("method is empty");
                }catch (Exception e){

                }
            }
            return null;
        }
        logger.info("ok");
        return null;
    }
}
