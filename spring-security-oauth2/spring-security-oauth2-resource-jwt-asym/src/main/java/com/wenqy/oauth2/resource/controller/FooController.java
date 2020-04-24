package com.wenqy.oauth2.resource.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class FooController {

    public FooController() {
        super();
    }

    /**
     * e.g.
     * 	http://localhost:58092/oauth2-resource/foos/1?access_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1ODU0MDAzNzAsInVzZXJfbmFtZSI6ImFkbWluIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiIwN2U0ZjI0Ni00ZTc2LTQ5MGItODY2YS0zZmVhNDMxYjIxYzUiLCJjbGllbnRfaWQiOiJiYXJDbGllbnRJZFBhc3N3b3JkIiwic2NvcGUiOlsiYmFyIiwicmVhZCIsIndyaXRlIl19.ItoeNHgbPnsjbhCEEJsaoRI5yonL-xsh3F-Xg2X64-o
     * @param id
     * @return
     * @author wenqy
     * @date 2020年3月28日 下午8:58:46
     */
    // API - read
    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping(method = RequestMethod.GET, value = "/foos/{id}")
    @ResponseBody
    public String findById(@PathVariable final long id) {
    	return "" + id;
    }

    // API - write
    @PreAuthorize("#oauth2.hasScope('foo') and #oauth2.hasScope('write')")
    @RequestMapping(method = RequestMethod.POST, value = "/foos")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String create(@RequestBody final String foo) {
        return foo;
    }

    /**
     * 
     * @param authentication
     * @return
     * @author wenqy
     * @date 2020年4月9日 下午4:21:09
     */
    @RequestMapping(value = "/users")
    @ResponseBody
    public Object user(Authentication authentication) {
        return authentication;
    }
}
