/**
 * @Title MemoryTokenGenerater.java
 * @Package com.bees.security.oauth2.server.token
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-8-24 上午11:47:41
 * @version V1.0
 */
package com.bees.security.oauth2.server.token;

import org.apache.oltu.oauth2.common.token.OAuthToken;

import com.bees.security.oauth2.server.http.OAuthHttpRequest;
import com.bees.security.oauth2.server.util.TokenUtils;

/**
 * @ClassName MemoryTokenGenerater
 * @Description TODO
 * 
 */
public class MemoryTokenGenerater extends AbstractTokenGenerater {

	public MemoryTokenGenerater(OAuthHttpRequest request) {
		super(request);
	}

	@Override
	public OAuthToken createToken(OAuthHttpRequest request) {
		String accessToken = TokenUtils.Md5Token(request);
		SimpleOAuthToken sot = new SimpleOAuthToken(accessToken, "bear");
		return sot;
	}

}
