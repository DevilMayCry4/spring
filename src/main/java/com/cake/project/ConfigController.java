package com.cake.project;

 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cake.project.Model.CityServer;
import com.cake.project.Model.ResponCode;
import com.cake.project.Model.ResponDataObject;
 
@RestController
public class ConfigController extends BaseController {
	
	@RequestMapping(value="/district/city/list.do",method = RequestMethod.POST)
	public ResponDataObject getCityList(){
		ResponDataObject object = new ResponDataObject();
	    CityServer server = new CityServer();
	    server.jdbcTemplate = jdbcTemplate;
	    object.setCode(ResponCode.success);;
	    object.setItems(server.getCitylist());
		return object;
		
	}

}
