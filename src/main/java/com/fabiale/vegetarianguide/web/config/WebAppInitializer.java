package com.fabiale.vegetarianguide.web.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

public class WebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext context) throws ServletException {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.setServletContext(context);
		appContext.scan("com.fabiale.vegetarianguide.spring.context");
		appContext.refresh();
		
		FilterRegistration.Dynamic sitemeshFilter = context.addFilter("sitemesh", new SiteMeshFilter());
		sitemeshFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class),false,"/*");
		
		ServletRegistration.Dynamic dispatcher = context.addServlet("dispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
}
