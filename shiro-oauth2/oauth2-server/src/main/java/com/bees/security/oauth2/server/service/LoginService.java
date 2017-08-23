/**
 * @Title LoginService.java
 * @Package com.bees.security.oauth2.server.service
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-8-28 下午6:00:02
 * @version V1.0
 */
package com.bees.security.oauth2.server.service;

import com.bees.security.oauth2.server.domain.UserInfo;

/**
 * @ClassName LoginService
 * @Description TODO
 * 
 */
public interface LoginService {
	public UserInfo getLoginUserInfo(String userName);
}
