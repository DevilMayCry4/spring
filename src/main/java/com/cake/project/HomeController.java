package com.cake.project;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.apache.taglibs.standard.extra.spath.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController; 
import com.cake.project.Version;
import com.cake.project.ResponDataObject;

/**
 * Handles requests for the application home page.
 */
@RestController
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
    @RequestMapping(value="/platform/version/get.do")
    public Version getVersion(){
    	Version v = new Version("https://www.baidu.com/","https://www.baidu.com/","https://www.baidu.com/",
    			"https://www.baidu.com/","https://www.baidu.com/",0, "https://www.baidu.com/", "更新提示");
    	return v;
    }

   
   @ResponseBody
   @ExceptionHandler(MissingServletRequestParameterException.class)
   public Object missingParamterHandler(final Exception exception) {
	   
       // exception handle while specified arguments are not available requested service only. it handle when request is as api json service       
       return  new HashMap() {{ put("result", "failed"); put("type", exception.getClass().getName());}};
   } 
}
