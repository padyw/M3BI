package com.pramod.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class BookingNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8951617077631440992L;

	public BookingNotFoundException(String message) {
		super(message);
	}
}
