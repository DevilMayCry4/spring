package com.cake.project;

  
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController;

import com.cake.project.Model.PropertyService;
import com.cake.project.Model.CityServer; 
import com.cake.project.Model.ResponCode;
import com.cake.project.Model.ResponDataObject; 
import org.json.JSONObject;
 
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
	public ResponDataObject getPropertyList(@RequestBody String  cityString){
		ResponDataObject object = new ResponDataObject();
	    PropertyService service = new PropertyService();
	    service.jdbcTemplate = jdbcTemplate;
	    object.setCode(ResponCode.success);
	    JSONObject params = new JSONObject(cityString);
	    String paremtId = params.getString("parentId");
	    if (paremtId != null) {

	    	 object.setItems(service.getPropertyLsit(paremtId));
		}
	    else{
	    	 int cityId = params.getInt("cityId");
	    	 object.setItems(service.getPropertyLsit(cityId));
	    }
	   
		return object;
	}
}
