package com.fabiale.vegetarianguide.exception;


public class RestaurantNotFoundException extends Exception {

	private static final long serialVersionUID = -2867415563978162444L;

	public RestaurantNotFoundException() {
		super();
	}

	public RestaurantNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RestaurantNotFoundException(String message) {
		super(message);
	}

	public RestaurantNotFoundException(Throwable cause) {
		super(cause);
	}
}
