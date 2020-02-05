package com.wenqy.trace.provider;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraceProviderController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/trace-2")
    public String trace(HttpServletRequest request) {
    	logger.info("===<call trace-2, TraceId={}, SpanId={}>===",
    			request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId"));
    	return "Trace";
    }
}
