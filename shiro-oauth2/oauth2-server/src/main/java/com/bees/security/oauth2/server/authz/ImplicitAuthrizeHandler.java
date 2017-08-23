/**
 * @Title ImplicitAuthrizeHandler.java
 * @Package com.bees.security.oauth2.server.authz
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-8-28 下午4:42:52
 * @version V1.0
 */
package com.bees.security.oauth2.server.authz;

import javax.servlet.http.HttpServletResponse;

import com.bees.security.oauth2.server.http.OpenOAuthAuthzRequest;

/**
 * @ClassName ImplicitAuthrizeHandler
 * @Description TODO
 * 
 */
public class ImplicitAuthrizeHandler extends AbstractAuthorizeHandler {

	public ImplicitAuthrizeHandler(OpenOAuthAuthzRequest request,
			HttpServletResponse response) {
		super(request, response);
	}

	@Override
	public void handleResponse() {
	}

}
