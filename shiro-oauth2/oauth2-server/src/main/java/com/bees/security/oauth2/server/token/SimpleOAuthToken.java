/**
 * @Title SimpleOAuthToken.java
 * @Package com.bees.security.oauth2.server.token
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-8-24 上午11:46:00
 * @version V1.0
 */
package com.bees.security.oauth2.server.token;

import org.apache.oltu.oauth2.common.token.BasicOAuthToken;

/**
 * @ClassName SimpleOAuthToken
 * @Description TODO
 * 
 */
public class SimpleOAuthToken extends BasicOAuthToken {

	private final static long DEFAULT_EXPIRES_IN = 24 * 60 * 60;

	public SimpleOAuthToken(String accessToken, String tokenType) {
		super(accessToken, tokenType, DEFAULT_EXPIRES_IN);
	}

	public SimpleOAuthToken(String accessToken, String tokenType, String scope) {
		this(accessToken, tokenType, DEFAULT_EXPIRES_IN, scope);
	}

	public SimpleOAuthToken(String accessToken, String tokenType,
			long expiresIn, String scope) {
		super(accessToken, tokenType, expiresIn, scope);
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@Override
	public String toString() {
		return "SimpleOAuthToken [accessToken=" + accessToken + ", tokenType="
				+ tokenType + ", expiresIn=" + expiresIn + ", refreshToken="
				+ refreshToken + ", scope=" + scope + "]";
	}

}
