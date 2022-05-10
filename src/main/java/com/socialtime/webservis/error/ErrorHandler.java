package com.socialtime.webservis.error;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.error.ErrorAttributeOptions.Include;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.context.request.WebRequest;

public class ErrorHandler implements ErrorController {
	
	@Autowired
	private ErrorAttributes errorAttributes;
	 
	@RequestMapping("/error")
	ApiError handleError(WebRequest webRequest) {
		Map<String, Object> attributes = this.errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.of(Include.MESSAGE, Include.BINDING_ERRORS));
		String message = (String)attributes.get("message");
		String path = (String) attributes.get("path");
		int status = (Integer) attributes.get("status");
		return new  ApiError(status, message, path);
	}
	
	 
	 
}
