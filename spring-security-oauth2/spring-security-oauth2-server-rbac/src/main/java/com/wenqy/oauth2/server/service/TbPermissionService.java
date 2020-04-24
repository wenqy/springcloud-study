package com.wenqy.oauth2.server.service;

import java.util.List;

import com.wenqy.oauth2.server.entity.TbPermission;

public interface TbPermissionService {
	
    default List<TbPermission> selectByUserId(Long userId) {
        return null;
    }
}