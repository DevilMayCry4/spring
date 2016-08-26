package com.cake.project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController extends BaseController {
	
	private final String methodName = "/customer/";
	
    @RequestMapping(value= methodName + "login.do" ,method = RequestMethod.POST)
    public ResponDataObject  login(@RequestParam(value ="loginPassword") String loginPassword, @RequestParam(value="loginName") String name){
    	ResponDataObject responDataObject = new ResponDataObject();
    	responDataObject.code = ResponCode.success;
    	responDataObject.getItem().put("s", "v"); 
    	return responDataObject;
    }
    
   public ResponDataObject isLogin(String token) {
	    ResponDataObject r = new ResponDataObject();
	    if (token != null && token.length() > 0 ) {
			return null;
		}
	    else{
	    	r.code = ResponCode.needLogin;
	    	r.msg = "未登录";
	    }
	   return r; 
}

}
