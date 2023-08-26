package com.spring.pos.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GloabExceptionController {

	@ExceptionHandler({ Exception.class})
	@ResponseBody
	public ResponseStatus handleException(Exception ex) {
		ResponseStatus responseStatus = new ResponseStatus("Error");
		responseStatus.setMessages(ex.getMessage());
		return responseStatus;
	}
}
