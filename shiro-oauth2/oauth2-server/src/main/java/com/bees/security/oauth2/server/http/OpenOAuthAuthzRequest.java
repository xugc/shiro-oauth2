/**
 * @Title OpenOAuthAuthzRequest.java
 * @Package com.bees.security.oauth2.server.http
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-8-28 下午5:07:38
 * @version V1.0
 */
package com.bees.security.oauth2.server.http;

import javax.servlet.http.HttpServletRequest;

import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.ResponseType;

/**
 * @ClassName OpenOAuthAuthzRequest
 * @Description TODO
 * 
 */
public class OpenOAuthAuthzRequest extends OAuthAuthzRequest {

	public OpenOAuthAuthzRequest(HttpServletRequest request)
			throws OAuthSystemException, OAuthProblemException {
		super(request);
	}

	public boolean isCode() {
		return ResponseType.CODE.toString().equals(getResponseType());
	}

	public boolean isToken() {
		return ResponseType.TOKEN.toString().equals(getResponseType());
	}

	public HttpServletRequest getRequest() {
		return this.request;
	}
}
