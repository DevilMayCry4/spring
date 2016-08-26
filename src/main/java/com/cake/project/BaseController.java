package com.cake.project;

import java.util.HashMap;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class BaseController {

	 @ResponseBody
	   @ExceptionHandler(MissingServletRequestParameterException.class)
	   public Object missingParamterHandler(final Exception exception) {
		   
	       // exception handle while specified arguments are not available requested service only. it handle when request is as api json service       
	       return  new HashMap() {{ put("result", "failed"); put("type", exception.getClass().getName());}};
	   } 
}
