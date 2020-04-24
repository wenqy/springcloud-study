package com.wenqy.oauth2.server.service;

import com.wenqy.oauth2.server.entity.TbUser;

public interface TbUserService {
	
    default TbUser getByUsername(String username) {
        return null;
    }
}