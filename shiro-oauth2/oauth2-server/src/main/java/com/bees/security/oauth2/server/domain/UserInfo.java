/**
 * @Title UserInfo.java
 * @Package com.bees.security.oauth2.server.domain
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-8-28 下午6:22:59
 * @version V1.0
 */
package com.bees.security.oauth2.server.domain;

/**
 * @ClassName UserInfo
 * @Description TODO
 * 
 */
public class UserInfo {
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
