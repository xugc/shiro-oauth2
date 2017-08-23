/**
 * @Title OauthHttpRequest.java
 * @Package com.bees.security.oauth2.server.http
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-8-24 上午10:08:23
 * @version V1.0
 */
package com.bees.security.oauth2.server.http;

import javax.servlet.http.HttpServletRequest;

import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

/**
 * @ClassName OauthHttpRequest
 * @Description TODO
 * 
 */
public class OAuthHttpRequest extends OAuthTokenRequest {

	public OAuthHttpRequest(HttpServletRequest request)
			throws OAuthSystemException, OAuthProblemException {
		super(request);
	}
}
