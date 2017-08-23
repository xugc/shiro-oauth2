/**
 * @Title LoginController.java
 * @Package com.bees.security.oauth2.server.controller
 * @Description TODO
 * Copyright: Copyright (c) 2017 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2017-8-29 上午11:09:14
 * @version V1.0
 */
package com.bees.security.oauth2.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName LoginController
 * @Description TODO
 * 
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin() {
		return "login";
	}
}
