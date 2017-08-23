package com.bees.security.oauth2.server.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.bees.security.oauth2.server.realm.DefaultAuthorizingRealm;

/**
 * @ClassName ShiroConfiguration
 * @Description TODO
 * 
 */
@Configuration
public class ShiroConfiguration {
	/**
	 * 注册DelegatingFilterProxy（Shiro）
	 * 
	 * @param dispatcherServlet
	 * @return * @author SHANHY
	 * @create 2016年1月13日
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
		filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
		// 该值缺省为false,表示生命周期由SpringApplicationContext管理,设置为true则表示由ServletContainer管理
		filterRegistration.addInitParameter("targetFilterLifecycle", "true");
		filterRegistration.setEnabled(true);
		filterRegistration.addUrlPatterns("/*");
		return filterRegistration;
	}

	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
		daap.setProxyTargetClass(true);
		return daap;
	}

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(
			DefaultAuthorizingRealm defaultAuthorizingRealm) {
		DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
		dwsm.setRealm(defaultAuthorizingRealm);
		dwsm.setCacheManager(new RedisCacheManager());
		return dwsm;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(
			DefaultAuthorizingRealm defaultAuthorizingRealm) {
		AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
		aasa.setSecurityManager(getDefaultWebSecurityManager(defaultAuthorizingRealm));
		return new AuthorizationAttributeSourceAdvisor();
	}

	/**
	 * 加载shiroFilter权限控制规则（从数据库读取然后配置）
	 * 
	 * @author 
	 * @create 
	 */
	private void loadShiroFilterChain(
			ShiroFilterFactoryBean shiroFilterFactoryBean) {
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		//
		// filterChainDefinitionMap.put("/admin/main",
		// "authc,perms[admin:manange]");//有顺序的同一个请求按照第一个来
		filterChainDefinitionMap.put("/oauth/token", "anon"); // anon 可以理解为不拦截
		shiroFilterFactoryBean
				.setFilterChainDefinitionMap(filterChainDefinitionMap);
	}

	/**
	 * ShiroFilter<br/>
	 * 
	 * @param defaultAuthorizingRealm
	 * @return * @author 
	 * @create 
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(
			DefaultAuthorizingRealm defaultAuthorizingRealm) {

		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean(); // 必须设置
		shiroFilterFactoryBean
				.setSecurityManager(getDefaultWebSecurityManager(defaultAuthorizingRealm));

		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/login");
		// 登录成功后要跳转的连接
		shiroFilterFactoryBean.setSuccessUrl("/success");
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");

		loadShiroFilterChain(shiroFilterFactoryBean);
		return shiroFilterFactoryBean;
	}
}
