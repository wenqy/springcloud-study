package com.wenqy.provider.parser;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;

/**
 * 基于调用关系的限流
 * 		https://github.com/alibaba/Sentinel/wiki/FAQ#q-%E6%80%8E%E4%B9%88%E9%92%88%E5%AF%B9%E7%89%B9%E5%AE%9A%E8%B0%83%E7%94%A8%E7%AB%AF%E9%99%90%E6%B5%81%E6%AF%94%E5%A6%82%E6%88%91%E6%83%B3%E9%92%88%E5%AF%B9%E6%9F%90%E4%B8%AA-ip-%E6%88%96%E8%80%85%E6%9D%A5%E6%BA%90%E5%BA%94%E7%94%A8%E8%BF%9B%E8%A1%8C%E9%99%90%E6%B5%81%E8%A7%84%E5%88%99%E9%87%8C%E9%9D%A2-limitapp%E6%B5%81%E6%8E%A7%E5%BA%94%E7%94%A8%E7%9A%84%E4%BD%9C%E7%94%A8
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年2月21日
 */
@Component
public class CallerOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {
    	// 指定调用来源，传入调用方 注意 origin 数量不能太多，否则会导致内存暴涨，并且目前不支持模式匹配。
    	String appName = request.getHeader("CUSTOM_APPNAME");
        return appName;
    }
}