package com.cake.project;

   
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cake.project.Model.PropertyService;
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
	
	@RequestMapping(value="/property/list.do",method = RequestMethod.POST)
	public ResponDataObject getPropertyList(@RequestParam(name = "parentId",required=false ) String parentId ,
			@RequestParam(name="cityId",required=false) String cityId){
		ResponDataObject object = new ResponDataObject();
	    PropertyService service = new PropertyService();
	    service.jdbcTemplate = jdbcTemplate;
	    object.setCode(ResponCode.success); 
	    if (parentId != null) {

	    	 object.setItems(service.getPropertyLsit(parentId));
		}
	    else if(cityId != null){ 
	    	
	    	 object.setItems(service.getPropertyLsit(Integer.parseInt(cityId)));
	    }else{
	    	object.setCode(ResponCode.requireParam);
	    	object.setMsg("miss parentId or cityI");
	    }
	   
		return object;
	}
}
