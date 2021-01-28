package com.pramod.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class HotelNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6272496091960726476L;

	public HotelNotFoundException(String message) {
		super(message);
	}
}
