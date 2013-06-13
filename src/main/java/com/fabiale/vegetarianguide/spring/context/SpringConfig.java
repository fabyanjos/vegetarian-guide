package com.fabiale.vegetarianguide.spring.context;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

import com.fabiale.vegetarianguide.spring.DropboxConfig;
import com.fabiale.vegetarianguide.spring.RepositoryConfig;
import com.fabiale.vegetarianguide.spring.RestTemplateConfig;
import com.fabiale.vegetarianguide.spring.SpringSecurityConfig;
import com.fabiale.vegetarianguide.spring.UploadConfig;
import com.fabiale.vegetarianguide.spring.WebConfig;

@Configuration
@ComponentScan(value = "com.fabiale.vegetarianguide", excludeFilters = @ComponentScan.Filter(Configuration.class))
@Import({ RepositoryConfig.class, WebConfig.class, RestTemplateConfig.class, SpringSecurityConfig.class, UploadConfig.class, DropboxConfig.class })
public class SpringConfig {

	@Bean
	public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("application.properties"));
		ppc.setIgnoreUnresolvablePlaceholders(true);
		return ppc;
	}
}