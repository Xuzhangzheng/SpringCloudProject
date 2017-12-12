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
public class CloudFliterPre extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(CloudFliterPre.class) ;

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
        但是否生效由shouldFliter控制
        过滤器执行时，先按照过滤器类型进行执行，同过滤器类型时，过滤顺利才会生效
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
        if(1==properties.fliterFlag_pre) {
            return true;
        }
        return false ;
    }

    /*
    run：过滤器的具体逻辑。
    可以编写业务逻辑，包括查sql，nosql去判断该请求到底有没有权限访问。
    这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求，不对其进行路由。
    然后通过ctx.setResponseStatusCode(401)设置了其返回的错误码
    过滤器没有直接的方式来访问对方。
    它们可以使用RequestContext共享状态，这是一个类似Map的结构，具有一些显式访问器方法用于被认为是Zuul的原语，内部是使用ThreadLocal实现的，有兴趣的同学可以看下源码。
     */
    @Override
    public Object run() {
        logger.info("pre filter is running");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object clientName = request.getParameter("clientName");
        if(clientName == null || StringUtils.isEmpty((String)clientName) ) {
            logger.warn("clientName is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("clientName is empty");
            }catch (Exception e){

            }
            return null;
        }
        logger.info("ok");
        return null;
    }
}
