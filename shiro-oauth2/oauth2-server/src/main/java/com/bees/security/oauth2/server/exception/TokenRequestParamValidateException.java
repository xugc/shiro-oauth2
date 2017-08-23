/**
 * @Title TokenRequestParamValidateException.java
 * @Package com.bees.security.oauth2.server.exception
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-8-28 上午10:10:46
 * @version V1.0
 */
package com.bees.security.oauth2.server.exception;

/**
 * @ClassName TokenRequestParamValidateException
 * @Description TODO
 * 
 */
public class TokenRequestParamValidateException extends RuntimeException {

	private static final long serialVersionUID = -2033545603841569692L;

	public TokenRequestParamValidateException(String ex) {
		super(ex);
	}

}
