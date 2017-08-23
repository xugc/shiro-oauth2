/**
 * @Title OauthAuthorizeController.java
 * @Package com.bees.security.oauth2.server.controller
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-8-28 下午4:39:21
 * @version V1.0
 */
package com.bees.security.oauth2.server.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bees.security.oauth2.server.authz.CodeAuthorizeHandler;
import com.bees.security.oauth2.server.authz.ImplicitAuthrizeHandler;
import com.bees.security.oauth2.server.http.OpenOAuthAuthzRequest;

/**
 * @ClassName OauthAuthorizeController
 * @Description TODO
 * 
 */
@Controller
@RequestMapping("/oauth")
public class OAuthAuthorizeController {
	@RequestMapping("/authorize")
	public void authorize(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			OpenOAuthAuthzRequest ooar = new OpenOAuthAuthzRequest(request);
			if (ooar.isCode()) {
				CodeAuthorizeHandler cah = new CodeAuthorizeHandler(ooar,
						response);
				cah.handle();
			} else if (ooar.isToken()) {
				ImplicitAuthrizeHandler iah = new ImplicitAuthrizeHandler(ooar,
						response);
				iah.handle();
			}
		} catch (OAuthSystemException e) {
		} catch (OAuthProblemException e) {
		}
	}

	@RequestMapping(value = "/authorize", method = RequestMethod.POST, params = "auth_approval")
	public void approvalOrDeny(HttpServletRequest request,
			HttpServletResponse response) {

	}

	@RequestMapping("/approval")
	public String toApproval() {
		return "approval";
	}

}
