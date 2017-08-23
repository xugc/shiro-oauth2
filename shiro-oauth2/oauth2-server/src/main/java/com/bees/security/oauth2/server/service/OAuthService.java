/**
 * @Title OAuthService.java
 * @Package com.bees.security.oauth2.server.service
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-8-30 下午6:05:45
 * @version V1.0
 */
package com.bees.security.oauth2.server.service;

import com.bees.security.oauth2.server.domain.ClientDetails;

/**
 * @ClassName OAuthService
 * @Description TODO
 * 
 */
public interface OAuthService {
	public String getAuthCode(String clientId);
	public int saveAuthCode(ClientDetails client);
}
