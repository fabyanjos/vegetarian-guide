package com.fabiale.vegetarianguide.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan("com.fabiale.vegetarianguide")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**").addResourceLocations("/js/**");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/**");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/**");
		super.addResourceHandlers(registry);
	}
}
