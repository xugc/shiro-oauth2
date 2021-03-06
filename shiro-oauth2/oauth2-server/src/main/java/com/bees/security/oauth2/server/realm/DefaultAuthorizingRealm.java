package com.bees.security.oauth2.server.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bees.security.oauth2.server.domain.UserInfo;
import com.bees.security.oauth2.server.service.LoginService;

@Service
public class DefaultAuthorizingRealm extends AuthorizingRealm {
	private static final Logger logger = LoggerFactory
			.getLogger(DefaultAuthorizingRealm.class);

	// @Autowired
	// private UserMapper userMapper;

	@Autowired
	private LoginService loginService;

	/**
	 * 授权
	 * 
	 * @see 经测试：本例中该方法的调用时机为需授权资源被访问时
	 * @see 经测试：并且每次访问需授权资源时都会执行该方法中的逻辑，这表明本例中默认并未启用AuthorizationCache
	 * @see 经测试 
	 *      ：如果连续访问同一个URL（比如刷新），该方法不会被重复调用，Shiro有一个时间间隔（本人测试是2分钟），超过这个时间间隔再刷新页面
	 *      ，该方法会被执行
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {
		logger.info("-------------用户授权------------");
		// // 获取当前登录输入的用户名，等价于(String)
		// principalCollection.fromRealm(getName()).iterator().next();
		// String loginName = (String) super
		// .getAvailablePrincipal(principalCollection);
		// // 到数据库查是否有此对象
		// User user = userMapper.selectByUserName(loginName);
		// // 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
		// if (user != null) {
		// // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
		// SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// Set<String> roles = new HashSet<String>();
		// roles.add("admin");
		// // 用户的角色集合
		// info.setRoles(roles);
		// info.addStringPermission("admin:manange");
		// // 用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
		// // List<Role> roleList = user.getRoleList();
		// // for (Role role : roleList) {
		// // info.addStringPermissions(role.getPermissionsName());
		// // }
		// // 或者按下面这样添加 //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色 //
		// // simpleAuthorInfo.addRole("admin");
		// // // 添加权限 //
		// // simpleAuthorInfo.addStringPermission("admin:manage"); //
		// return info;
		// }
		// 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
		return null;
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken)
			throws AuthenticationException {
		logger.info("-----------认证用户信息-----------");
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		UserInfo user = loginService.getLoginUserInfo(token.getUsername());
		return new SimpleAuthenticationInfo(user.getUserName(),
				user.getPassword(), getName());
	}

	public static void main(String[] args) {
		String pwd = "123";
		System.out.println(new Md5Hash(pwd, "", 4).toBase64());
	}
}