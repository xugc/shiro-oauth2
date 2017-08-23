/**
 * @Title AccessTokenController.java
 * @Package com.bees.security.oauth2.server.controller
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-8-23 下午6:42:51
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

import com.bees.security.oauth2.server.http.OAuthHttpRequest;

/**
 * @ClassName AccessTokenController
 * @Description TODO
 * 
 */
@Controller
@RequestMapping("/oauth")
public class AccessTokenController {
	@RequestMapping(value = "/token", method = RequestMethod.GET)
	public void accessToken(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			OAuthHttpRequest oauthRequest = new OAuthHttpRequest(request);
			
		} catch (OAuthSystemException e) {
		} catch (OAuthProblemException e) {
		}
	}
}
