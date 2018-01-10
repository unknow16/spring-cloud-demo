package com.fuyi.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by fuyi on 2017/12/30.
 */
public class ThrowErrorFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(ThrowErrorFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        logger.info("this is a pre filter, it will be throw exception...");
        RequestContext currentContext = RequestContext.getCurrentContext();

        try {
            doSomething();
        } catch (Exception e) {
            currentContext.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            currentContext.set("error.exception", e);
        }

        return null;
    }

    private void doSomething() {
        throw new RuntimeException("i am a error...");
    }
}
