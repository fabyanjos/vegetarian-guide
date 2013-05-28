package com.fabiale.vegetarianguide.web;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerBinder {

	private Logger logger = Logger.getLogger(ExceptionHandlerBinder.class.getName());

	@ExceptionHandler({ RestClientException.class })
	public ModelAndView handleException(final RestClientException exception) {
		logger.log(Level.SEVERE, "Exception found: " + exception, exception);
		return errorModelAndView(exception, "");
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ModelAndView handleIOException(DataIntegrityViolationException ex) {
		ConstraintViolationException constraint = (ConstraintViolationException) ex.getCause();
		logger.log(Level.SEVERE, "handleIOException - Catching: " + ex.getClass().getSimpleName(), ex);
		return errorModelAndView(ex, constraint.getConstraintName() + ".error");
	}

	/**
	 * Get the users details for the 'personal' page
	 */
	private ModelAndView errorModelAndView(Exception ex, String msg) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		modelAndView.addObject("msg", msg);

		return modelAndView;
	}
}
