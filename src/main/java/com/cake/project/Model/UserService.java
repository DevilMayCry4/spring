package com.cake.project.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

 

public class UserService extends BaseService {
class UserRowMapper implements RowMapper<User> {
		
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
	
	public User getUser(String name){
		String query = String.format( "SELECT * FROM user WHERE loginName = %s", name);
		try {
			  User  user = jdbcTemplate.queryForObject(query,  new UserRowMapper());
				return user;	
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		} 
	}
	
	public Boolean createUser(String name,String password,String nickname,String fullName,String propertyId) {
		try {
			 String sql = String.format("INSERT INTO user (loginName, nickname,fullName,password) VALUES ('%s', '%s','%s','%s')",name,nickname,fullName,password);
			 jdbcTemplate.update(sql); 
		 
			 return this.updateProperty(name, propertyId) ;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}
	
	public boolean isUserAlreadyExist(String name) {
		return this.getUser(name) != null;
		
	}
	
	public Boolean updateProperty(String name,String propertyId) {
		try {
			 User user = this.getUser(name);
			 if (user != null) { 
				 String sql = String.format("INSERT INTO `cake`.`user_property` (`customId`, `propertyId`) VALUES ('%s', '%s')", user.customerId,propertyId);
				 jdbcTemplate.update(sql);
				 return true;
			}
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
		return false;
		
	}
	
	public List<Property> getUserProperty(String name) {
		
	}

}
