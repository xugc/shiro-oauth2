/**
 * @Title AbstractTokenGenerater.java
 * @Package com.bees.security.oauth2.server.token
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-8-25 下午6:23:50
 * @version V1.0
 */
package com.bees.security.oauth2.server.token;

import org.apache.oltu.oauth2.common.token.OAuthToken;

import com.bees.security.oauth2.server.exception.TokenRequestParamValidateException;
import com.bees.security.oauth2.server.http.OAuthHttpRequest;

/**
 * @ClassName AbstractTokenGenerater
 * @Description TODO
 * 
 */
public abstract class AbstractTokenGenerater implements TokenGenerater {
	private OAuthHttpRequest request;

	public AbstractTokenGenerater(OAuthHttpRequest request) {
		this.request = request;
	}

	@Override
	public OAuthToken getToken() {
		validateParamters();
		OAuthToken token = createToken(request);
		return token;
	}

	public void validateParamters() throws TokenRequestParamValidateException {
		validateUserRequestParams(request);
	}

	public void validateUserRequestParams(OAuthHttpRequest request)
			throws TokenRequestParamValidateException {
	}

	public abstract OAuthToken createToken(OAuthHttpRequest request);

}
