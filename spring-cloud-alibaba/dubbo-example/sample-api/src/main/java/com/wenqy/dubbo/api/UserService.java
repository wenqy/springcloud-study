package com.wenqy.dubbo.api;


import java.util.Collection;

import com.wenqy.dubbo.entity.User;


public interface UserService {

	boolean save(User user);

	boolean remove(Long userId);

	Collection<User> findAll();

}
