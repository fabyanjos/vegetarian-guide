package com.fabiale.vegetarianguide.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fabiale.vegetarianguide.service.ReviewService;

@Component
public class ReviewLoadInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired ReviewService reviewService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		request.setAttribute("reviewsList", reviewService.getLastUptades(4));
	}
}
