package com.cake.project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

 
import org.springframework.jdbc.core.RowMapper; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cake.project.Model.ResponCode;
import com.cake.project.Model.ResponDataObject;
import com.cake.project.Model.User;
import com.cake.project.Model.UserService;

@RestController
public class CustomerController extends BaseController {
	
	private final String methodName = "/customer/";
	
	 class EmployeeRowMapper implements RowMapper<User> {
	    @Override
	    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	User user = new User();
	    	user.setAvatar(rs.getString("avatar"));
	    	user.setCustomerId(rs.getString("customerId"));
	    	user.setFullName(rs.getString("fullName"));
	        user.setGender(rs.getString("gender"));
	        user.setNickname(rs.getString("nickname"));
	        return user;
	    }
 
	}

    @RequestMapping(value= methodName + "login.do" ,method = RequestMethod.POST)
    public ResponDataObject  login(@RequestParam(value ="loginPassword") String loginPassword, @RequestParam(value="loginName") String name){

    	ResponDataObject responDataObject = new ResponDataObject();
    	 
    	String query = String.format("SELECT * FROM users WHERE username = '%s' AND password = '%s'", name,loginPassword);
    	logger.info(query);
 
    	try {
    		List<User> users = (List<User>) jdbcTemplate.query(
    	    	    query, new EmployeeRowMapper());
    	    	if (users.isEmpty() == false &&  users.size() > 0)
    	        {
    	    		responDataObject.setCode(ResponCode.success);
    	        	responDataObject.getItem().put("user", users.get(0)); 
    			}
    	    	else{
    	     
    	    		if (this.isUserExist(name)) {
    	    			responDataObject.setCode(ResponCode.wrongPassword);
    	        		responDataObject.setMsg("密码错误");
    				}
    	    		else{
    	    			responDataObject.setCode(ResponCode.userNameNotExist);
    	        		responDataObject.setMsg( "用户不存在，请检查用户名");
    	    		}
    	    		
    	    	}
			
		} catch (Exception e) {
			// TODO: handle exception
			responDataObject.setCode(ResponCode.userNameNotExist);
    		responDataObject.setMsg( "用户不存在，请检查用户名");
    		logger.info(e.toString());
		}

    	
    	return responDataObject;
    }
    
    @RequestMapping(value= methodName + "register.do" ,method = RequestMethod.POST)
    public ResponDataObject regisgter(@RequestParam(value ="password") String password,
    		@RequestParam(value="cellphone") String name,
    		@RequestParam(value="nickName") String nickName,
    		@RequestParam(value="fullName") String fullName,
    		@RequestParam(value="relationType") String relationType,
    		@RequestParam(value="verifyCode") String verifyCode,
    		@RequestParam(value="propertyId",required=false) String propertyId,
    		@RequestParam(value="inviteCode",required=false) String inviteCode) {

    	UserService service = new UserService();
    	service.jdbcTemplate = jdbcTemplate;
    	ResponDataObject responDataObject = new ResponDataObject();
    	if (service.isUserAlreadyExist(name)) {
			responDataObject.setCode( ResponCode.userAlreadyExist);
			responDataObject.setMsg("用户已经存在");
		}else{
			 
			if (service.createUser(name, password, nickName, fullName,propertyId)) {	 
			responDataObject.setCode( ResponCode.success);
			
		 
				
			}else{
				responDataObject.setCode( ResponCode.excutionFail);
				responDataObject.setMsg("注册失败");
			}
		}
    	return responDataObject;
	}
    
    private boolean isUserExist (String userName) {
    	
    	String query = String.format("SELECT * FROM users WHERE username = '%s' ", userName);
    	try {
    		List<User> users = (List<User>) jdbcTemplate.query(
    	    	    query, new EmployeeRowMapper());
    		if (users.isEmpty() || users.size() == 0)
    		{
    			return false;
				
			}
			
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
    	return true;
	}
    
   public ResponDataObject isLogin(String token) {
	    ResponDataObject r = new ResponDataObject();
	    if (token != null && token.length() > 0 ) {
			return null;
		}
	    else{
	    	r.setCode(ResponCode.needLogin);
	    	r.setMsg("未登录");;
	    }
	   return r; 
}
   
   public void  setLoginUser(String name,ResponDataObject object){
		UserService service = new UserService();
    	service.jdbcTemplate = jdbcTemplate;
	    User user = service.getUser(name);
	    object.getItem().put("item", user);
	    name 
	   
   }

}
