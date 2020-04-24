package com.wenqy.oauth2.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wenqy.oauth2.server.entity.TbPermission;
import com.wenqy.oauth2.server.mapper.TbPermissionMapper;
import com.wenqy.oauth2.server.service.TbPermissionService;

@Service
public class TbPermissionServiceImpl implements TbPermissionService {

    @Resource
    private TbPermissionMapper tbPermissionMapper;

    @Override
    public List<TbPermission> selectByUserId(Long userId) {
        return tbPermissionMapper.selectByUserId(userId);
    }
}