/**
 * @Title OAuthCodeMapper.java
 * @Package com.bees.security.oauth2.server.dao
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-8-30 下午6:06:59
 * @version V1.0
 */
package com.bees.security.oauth2.server.dao;

/**
 * @ClassName OAuthCodeMapper
 * @Description TODO
 * 
 */
public interface OAuthCodeMapper {
	public int insertOAuthCode(String clientId, String OAuthCode);
}
