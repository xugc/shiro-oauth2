/**
 * @Title AbstractAuthorizeHandler.java
 * @Package com.bees.security.oauth2.server.authz
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-8-30 上午10:51:21
 * @version V1.0
 */
package com.bees.security.oauth2.server.authz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuer;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.springframework.beans.factory.annotation.Autowired;

import com.bees.security.oauth2.server.http.OpenOAuthAuthzRequest;
import com.bees.security.oauth2.server.service.OAuthService;

/**
 * @ClassName AbstractAuthorizeHandler
 * @Description TODO
 * 
 */
public abstract class AbstractAuthorizeHandler {
	private OpenOAuthAuthzRequest request;
	private HttpServletResponse response;

	private static final OAuthIssuer oauthIssuer = new OAuthIssuerImpl(
			new MD5Generator());

	@Autowired
	OAuthService oauthService;

	public AbstractAuthorizeHandler(OpenOAuthAuthzRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public void handle() {
		if (goApproval())
			return;
		if (!submitApproval())
			return;
		handleResponse();
	}

	private boolean goApproval() {
		try {
			HttpServletRequest httpRequest = request.getRequest();
			httpRequest.getRequestDispatcher("/oauth/approval").forward(
					httpRequest, response);
			return true;
		} catch (ServletException e) {
		} catch (IOException e) {
		}
		return false;
	}

	private boolean submitApproval() {
		String clientId = request.getClientId();
		String authCode = oauthService.getAuthCode(clientId);
		if (authCode == null) {
			try {
				authCode = oauthIssuer.authorizationCode();
			} catch (OAuthSystemException e) {
			}
		}
		return false;
	}

	public abstract void handleResponse();
}
