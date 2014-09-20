package com.fabiale.vegetarianguide.spring;

import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fabiale.vegetarianguide.gson.GSONHttpMessageConverter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
	
//	@Autowired ReviewLoadInterceptor reviewLoadInterceptor;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**").addResourceLocations("/js/**");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/**");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/**");
		registry.addResourceHandler("/channel.html").addResourceLocations("/channel.html");
		registry.addResourceHandler("/robots.txt").addResourceLocations("/robots.txt");
		registry.addResourceHandler("/sitemap.xml").addResourceLocations("/sitemap.xml");
		registry.addResourceHandler("/favicon.ico").addResourceLocations("/favicon.ico");
		registry.addResourceHandler("/404.html").addResourceLocations("/404.html");
		super.addResourceHandlers(registry);
	}
	
	@Bean public GSONHttpMessageConverter jsonConverter() {
		return new GSONHttpMessageConverter();
	}
	
	@Bean public Jaxb2RootElementHttpMessageConverter xmlConverter() {
		return new Jaxb2RootElementHttpMessageConverter();
	}
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(jsonConverter());
		converters.add(xmlConverter());
		super.configureMessageConverters(converters);
	}
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");

		return resolver;
	}
	
	@Bean
	public MessageSource messageSource() {

		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		String[] basenames = {
		    "i18n.messages.messages",
		    "i18n.countries.countries",
		    "i18n.labels.labels",
		};

		source.setBasenames(basenames);
		source.setUseCodeAsDefaultMessage(true);
		source.setDefaultEncoding("UTF-8");

		return source;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor result = new LocaleChangeInterceptor();
		result.setParamName("lang");

		return result;
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver result = new SessionLocaleResolver();
		result.setDefaultLocale(new Locale("pt","BR"));

		return result;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
//		registry.addInterceptor(reviewLoadInterceptor);
	}
}
