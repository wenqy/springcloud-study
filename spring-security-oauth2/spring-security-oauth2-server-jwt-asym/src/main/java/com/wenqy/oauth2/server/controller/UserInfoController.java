package com.wenqy.oauth2.server.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wenqy.oauth2.server.bean.UserInfo;

@RestController
public class UserInfoController {

	/**
	 * 获取userinfo
	 * @param authentication
	 * @return
	 * @author wenqy
	 * @date 2020年4月9日 下午5:31:14
	 */
    @RequestMapping("/userinfo")
    public ResponseEntity<UserInfo> profile(Authentication authentication) {
		User user = (User) authentication.getPrincipal();
		String email = user.getUsername() + "@qq.com";

		UserInfo profile = new UserInfo();
		profile.setName(user.getUsername());
		profile.setEmail(email);
		return ResponseEntity.ok(profile);
	}
}