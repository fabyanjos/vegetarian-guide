package com.fabiale.vegetarianguide.web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javassist.NotFoundException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.ModelAndView;

import com.dropbox.client2.exception.DropboxException;

@ControllerAdvice
public class ExceptionHandlerBinder {

	private Logger logger = Logger.getLogger(ExceptionHandlerBinder.class.getName());

	@ExceptionHandler({ RestClientException.class })
	public ModelAndView handleException(final RestClientException exception) {
		logger.log(Level.SEVERE, "Exception found: " + exception, exception);
		return errorModelAndView(exception, "");
	}
	
	@ExceptionHandler({ DropboxException.class })
	public ModelAndView handleException(final DropboxException exception) {
		logger.log(Level.SEVERE, "Exception found: " + exception, exception);
		return errorModelAndView(exception, "");
	}
	
	@ExceptionHandler({ NotFoundException.class })
	public ModelAndView handleException(final NotFoundException exception) {
		logger.log(Level.SEVERE, "Exception found: " + exception, exception);
		return errorModelAndView(exception, "");
	}
	
	@ExceptionHandler({ IOException.class })
	public ModelAndView handleException(final IOException exception) {
		logger.log(Level.SEVERE, "Exception found: " + exception, exception);
		return errorModelAndView(exception, "");
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ModelAndView handleIOException(DataIntegrityViolationException ex) {
		ConstraintViolationException constraint = (ConstraintViolationException) ex.getCause();
		logger.log(Level.SEVERE, "handleIOException - Catching: " + ex.getClass().getSimpleName(), ex);
		return errorModelAndView(ex, constraint.getConstraintName() + ".error");
	}
	
	@ExceptionHandler(AddressException.class)
	public ModelAndView handleIOException(AddressException ex) {
		ConstraintViolationException constraint = (ConstraintViolationException) ex.getCause();
		logger.log(Level.SEVERE, "handleIOException - Catching: " + ex.getClass().getSimpleName(), ex);
		return errorModelAndView(ex, constraint.getConstraintName() + ".error");
	}
	
	@ExceptionHandler(MessagingException.class)
	public ModelAndView handleIOException(MessagingException ex) {
		ConstraintViolationException constraint = (ConstraintViolationException) ex.getCause();
		logger.log(Level.SEVERE, "handleIOException - Catching: " + ex.getClass().getSimpleName(), ex);
		return errorModelAndView(ex, constraint.getConstraintName() + ".error");
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView handleIOException(NumberFormatException ex) {
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
