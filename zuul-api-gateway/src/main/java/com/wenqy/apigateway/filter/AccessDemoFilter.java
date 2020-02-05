package com.wenqy.apigateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 过滤器 demo
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月9日
 */
public class AccessDemoFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(AccessDemoFilter.class);
	
	@Override
	public boolean shouldFilter() {
		// 判断该过滤器是否需要被执行。true，该过滤器对所有请求都会生效。实际运用中我们可以利用该函数来指定过滤器的有效范围。
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
		Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false); // 不对其进行路由
            ctx.setResponseStatusCode(401);
            return null;
        }
        log.info("access token ok");
        return null;
	}

	@Override
	public String filterType() {
		// 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。pre，代表会在请求被路由之前执行
		return "pre";
	}

	@Override
	public int filterOrder() {
		// 过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行。
		return 0;
	}

}
