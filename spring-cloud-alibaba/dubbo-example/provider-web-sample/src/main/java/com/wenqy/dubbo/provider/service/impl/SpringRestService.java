package com.wenqy.dubbo.provider.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wenqy.dubbo.api.RestService;
import com.wenqy.dubbo.entity.User;
import com.wenqy.dubbo.utils.LoggerUtils;

@Service(version = "1.0.0")
@RestController
public class SpringRestService implements RestService {

	@Override
	@GetMapping("/param")
	public String param(@RequestParam String param) {
		LoggerUtils.log("/param", param);
		return param;
	}

	@Override
	@PostMapping("/params")
	public String params(@RequestParam int a, @RequestParam String b) {
		LoggerUtils.log("/params", a + b);
		return a + b;
	}

	@Override
	@GetMapping("/headers")
	public String headers(@RequestHeader("h") String header,
			@RequestHeader("h2") String header2, @RequestParam("v") Integer param) {
		String result = header + " , " + header2 + " , " + param;
		LoggerUtils.log("/headers", result);
		return result;
	}

	@Override
	@GetMapping("/path-variables/{p1}/{p2}")
	public String pathVariables(@PathVariable("p1") String path1,
			@PathVariable("p2") String path2, @RequestParam("v") String param) {
		String result = path1 + " , " + path2 + " , " + param;
		LoggerUtils.log("/path-variables", result);
		return result;
	}

	@Override
	@PostMapping("/form")
	public String form(@RequestParam("f") String form) {
		return String.valueOf(form);
	}

	@Override
	@PostMapping(value = "/request/body/map",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public User requestBodyMap(@RequestBody Map<String, Object> data,
			@RequestParam("param") String param) {
		User user = new User();
		user.setId(((Integer) data.get("id")).longValue());
		user.setName((String) data.get("name"));
		user.setAge((Integer) data.get("age"));
		LoggerUtils.log("/request/body/map", param);
		return user;
	}

	@PostMapping(value = "/request/body/user",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@Override
	public Map<String, Object> requestBodyUser(@RequestBody User user) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", user.getId());
		map.put("name", user.getName());
		map.put("age", user.getAge());
		return map;
	}

}