package com.DiamondCafe.DiamondCafe.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler
	public String Error(Exception e) {
		e.printStackTrace();
		return "Exception/error";
	}
}
