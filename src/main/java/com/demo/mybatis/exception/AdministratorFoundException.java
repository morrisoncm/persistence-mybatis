package com.demo.mybatis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Administrator already exist!")
public class AdministratorFoundException extends RuntimeException {

	private static final long serialVersionUID = -1243983916098837764L;

	public AdministratorFoundException() {
		super();
	}
}