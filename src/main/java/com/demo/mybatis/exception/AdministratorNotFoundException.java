package com.demo.mybatis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Administrator does not exist!")
public class AdministratorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1930618664658063212L;

	public AdministratorNotFoundException() {
		super();
	}
}
