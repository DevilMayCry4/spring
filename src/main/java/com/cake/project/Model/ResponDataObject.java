package com.cake.project.Model; 
import java.util.HashMap;
import java.util.List;

import com.cake.project.Model.ResponCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponDataObject {

 ResponCode code;
    String msg;
	private HashMap<String, Object> mItem;
	 List<?> items;
	
	public ResponCode getCode() {
		return code;
	}
	
	public String getMsg() {
		return msg;
	}
	

	public void setCode(ResponCode c){
		code = c;
	}
	public void setMsg(String s) {
		msg = s;
		
	}
	
	public HashMap<String, Object> getItem() {
		if (mItem == null) {
			mItem = new HashMap<String, Object>(); 
		}
		return mItem;
	}
	
 
	
	public List<?> getItems() {
		return items;
	}
	
	public void setItems(List<?> items) {
		this.items = items;
	}
	
	

}
