package com.demo.mybatis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Admiinistrator does not exist!")
public class AdmiinistratorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1930618664658063212L;

	public AdmiinistratorNotFoundException() {
		super();
	}
}
