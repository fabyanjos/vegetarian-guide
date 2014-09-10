package com.fabiale.vegetarianguide.web.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import com.fabiale.vegetarianguide.web.filter.ClearSitemeshAppliedOnceFilter;
import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

public class WebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext context) throws ServletException {
		// Load application context
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.setServletContext(context);
		appContext.scan("com.fabiale.vegetarianguide.spring.context");
		appContext.refresh();
		
		// Add context loader listener 
		context.addListener(new ContextLoaderListener(appContext));
		
		this.sitemesh(context);
		
		this.encodingFilter(context);
		
		// Register Spring security filter
		FilterRegistration.Dynamic springSecurityFilterChain = context.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
		springSecurityFilterChain.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), false, "/*");
		
		FilterRegistration.Dynamic crossOrigin = context.addFilter("cross-origin", CrossOriginFilter.class);
		crossOrigin.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), false, "/*");

		// Declare dispatcher servlet
		ServletRegistration.Dynamic dispatcher = context.addServlet("dispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

	private void sitemesh(ServletContext context) {
		FilterRegistration.Dynamic sitemeshFilter = context.addFilter("sitemesh", new SiteMeshFilter());
		sitemeshFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class),false,"*");
		
		FilterRegistration.Dynamic clearSiteMeshAppliedOnce = context.addFilter("clearSiteMeshAppliedOnce", new ClearSitemeshAppliedOnceFilter());
		clearSiteMeshAppliedOnce.addMappingForUrlPatterns(EnumSet.of(DispatcherType.ERROR), false, "*");
	}

	private void encodingFilter(ServletContext context) {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		Dynamic urtf8Filter = context.addFilter("encoding-filter" , characterEncodingFilter);
		urtf8Filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class),false,"/*");
	}
}
