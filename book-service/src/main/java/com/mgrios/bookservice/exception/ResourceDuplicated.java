package com.mgrios.bookservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
public class ResourceDuplicated extends RuntimeException{

	private static final long serialVersionUID = -8720477892251927163L;

	public ResourceDuplicated(String message) {
		super(message);
	}
}
