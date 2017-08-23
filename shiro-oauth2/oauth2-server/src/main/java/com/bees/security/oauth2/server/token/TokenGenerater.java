/**
 * @Title TokenGenerater.java
 * @Package com.bees.security.oauth2.server.token
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-8-24 上午11:46:57
 * @version V1.0
 */
package com.bees.security.oauth2.server.token;

import org.apache.oltu.oauth2.common.token.OAuthToken;

/**
 * @ClassName TokenGenerater
 * @Description TODO
 * 
 */
public interface TokenGenerater {
	public OAuthToken getToken();
}
