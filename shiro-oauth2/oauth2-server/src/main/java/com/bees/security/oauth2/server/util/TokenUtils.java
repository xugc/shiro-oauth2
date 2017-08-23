/**
 * @Title TokenUtils.java
 * @Package com.bees.security.oauth2.server.util
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-8-28 上午10:48:01
 * @version V1.0
 */
package com.bees.security.oauth2.server.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.oltu.oauth2.common.OAuth;

import com.bees.security.oauth2.server.http.OAuthHttpRequest;

/**
 * @ClassName TokenUtils
 * @Description TODO
 * 
 */
public class TokenUtils {
	public static String Md5Token(OAuthHttpRequest request) {
		String clientId = request.getClientId();
		String grantType = request.getGrantType();
		Set<String> scope = request.getScopes();
		Map<String, String> values = new LinkedHashMap<String, String>();
		// if (!request.) {
		// values.put(OAuth.OAUTH_USERNAME, request.getUsername());
		// }
		values.put(OAuth.OAUTH_CLIENT_ID, clientId);
		if (scope != null) {
			StringBuilder sb = new StringBuilder();
			for (String s : scope) {
				sb.append(s);
				sb.append(" ");
			}
			values.put(OAuth.OAUTH_SCOPE, sb.toString());
		}
		if (grantType != null) {
			values.put(OAuth.OAUTH_GRANT_TYPE, grantType);
		}
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
		}

		byte[] bytes = null;
		try {
			bytes = digest.digest(values.toString().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.format("%032x", new BigInteger(1, bytes));
	}
}
