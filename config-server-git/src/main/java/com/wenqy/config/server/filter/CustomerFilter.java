package com.wenqy.config.server.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;

/**
 * 测试Git Webhook 会传递多余参数，报400错误：
 * 		Can not deserialize instance of java.lang.String out of START_ARRAY token
 * 	这里特殊处理 Webhook请求
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年1月13日
 */
@WebFilter(filterName = "customerFilter", urlPatterns = "/*")
@Order(1)
public class CustomerFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;

        String url = new String(httpServletRequest.getRequestURI());

        //只过滤/actuator/bus-refresh请求
        if (!url.endsWith("/refresh") 
        		&& !url.endsWith("/bus-refresh")
        		&& !url.endsWith("/monitor")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //使用HttpServletRequest包装原始请求达到修改post请求中body内容的目的
        CustomerRequestWrapper requestWrapper = new CustomerRequestWrapper(httpServletRequest);

        filterChain.doFilter(requestWrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}