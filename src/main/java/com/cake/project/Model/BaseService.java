package com.cake.project.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import org.springframework.jdbc.core.JdbcTemplate;
 

public class BaseService {
 
	
	static final Logger logger = LoggerFactory.getLogger(BaseService.class);
	
	public  JdbcTemplate  jdbcTemplate;
	
	 

}
