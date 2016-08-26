package com.cake.project;
 

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler; 
import com.cake.project.ResponCode;
public class BaseController {

	static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponDataObject handleMissingServletRequestParameterException(MissingServletRequestParameterException e,
	        HttpServletRequest request) {
        String mString =  e.getParameterName() + " missing";
        
		logger.info(mString);
		
		ResponDataObject object = new ResponDataObject();
		object.code = ResponCode.needLogin;
		object.msg = mString;
		return object;
		
	}
}
