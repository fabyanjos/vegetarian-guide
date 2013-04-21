package com.fabiale.vegetarianguide.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fabiale.vegetarianguide.gson.GSONHttpMessageConverter;

@Configuration
public class RestTemplateConfig {
	
	@Autowired private GSONHttpMessageConverter jsonConverter;
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(jsonConverter);
		return restTemplate;
	}
}
