package com.cake.project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController extends BaseController {
	
	
    @RequestMapping(value="/customer/login.do",method = RequestMethod.POST)
    public ResponDataObject  login(@RequestParam(value ="token") String token, @RequestParam(value="loginName") String name){
  
    	return this.isLogin(token);
    }
    
   public ResponDataObject isLogin(String token) {
	    ResponDataObject r = new ResponDataObject();
	    if (token != null && token.length() > 0 ) {
			r.mCode = "200";
			r.mMsg = "";
		}
	    else{
	    	r.mCode = "430";
	    	r.mMsg = "未登录";
	    }
	   return r; 
}

}
