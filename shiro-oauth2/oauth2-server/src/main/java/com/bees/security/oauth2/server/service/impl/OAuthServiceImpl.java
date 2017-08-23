/**
 * @Title OAuthServiceImpl.java
 * @Package com.bees.security.oauth2.server.service.impl
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-9-4 下午3:00:14
 * @version V1.0
 */
package com.bees.security.oauth2.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bees.security.oauth2.server.dao.OAuthCodeMapper;
import com.bees.security.oauth2.server.domain.ClientDetails;
import com.bees.security.oauth2.server.service.OAuthService;

/**
 * @ClassName OAuthServiceImpl
 * @Description TODO
 * 
 */
public class OAuthServiceImpl implements OAuthService {
	@Autowired
	OAuthCodeMapper oauthCodeMapper;

	@Override
	public String getAuthCode(String clientId) {
		return null;
	}

	@Override
	public int saveAuthCode(ClientDetails client) {
		return 0;
	}

}
