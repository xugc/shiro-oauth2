/**
 * @Title LoginServiceImpl.java
 * @Package com.bees.security.oauth2.server.service.impl
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-8-28 下午6:01:42
 * @version V1.0
 */
package com.bees.security.oauth2.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bees.security.oauth2.server.dao.UserMapper;
import com.bees.security.oauth2.server.domain.UserInfo;
import com.bees.security.oauth2.server.service.LoginService;

/**
 * @ClassName LoginServiceImpl
 * @Description TODO
 * 
 */
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	UserMapper userMapper;

	@Override
	public UserInfo getLoginUserInfo(String userName) {
		return userMapper.selectUser(userName);
	}

}
