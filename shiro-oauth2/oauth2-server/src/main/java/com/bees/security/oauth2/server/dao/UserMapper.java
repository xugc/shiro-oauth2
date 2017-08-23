/**
 * @Title UserMapper.java
 * @Package com.bees.security.oauth2.server.dao
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-8-28 下午6:02:15
 * @version V1.0
 */
package com.bees.security.oauth2.server.dao;

import com.bees.security.oauth2.server.domain.UserInfo;

/**
 * @ClassName UserMapper
 * @Description TODO
 * 
 */
public interface UserMapper {
	public UserInfo selectUser(String userName);
}
