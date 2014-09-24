package com.fabiale.vegetarianguide.spring;

import java.io.FileNotFoundException;

import org.brickred.socialauth.SocialAuthConfig;
import org.brickred.socialauth.spring.bean.SocialAuthTemplate;
import org.brickred.socialauth.spring.bean.SpringSocialAuthManager;
import org.brickred.socialauth.spring.controller.SocialAuthWebController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SocialauthConfig {
	
	@Value("${social.successPageURL}") private String successPageURL;
	@Value("${social.accessDeniedPageURL}") private String accessDeniedPageURL;
	private String applicationUrl = System.getenv("APPLICATION_URL");

	@Bean
	public SocialAuthConfig socialAuthConfig() throws FileNotFoundException, Exception {
		SocialAuthConfig config = new SocialAuthConfig();
		config.load();
		return config;
	}
	
	@Bean
	public SpringSocialAuthManager springSocialAuthManager() throws FileNotFoundException, Exception {
		return new SpringSocialAuthManager();
	}
	
	@Bean
	public SocialAuthTemplate socialAuthTemplate() {
		return new SocialAuthTemplate();
	}
	
	@Bean
	public SocialAuthWebController socialAuthWebController() {
		return new SocialAuthWebController(applicationUrl, successPageURL, accessDeniedPageURL);
	}
}
