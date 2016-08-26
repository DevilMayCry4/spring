package com.cake.project;
import java.util.HashMap;
import com.cake.project.ResponCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponDataObject {

	ResponCode code;
    String msg;
	private HashMap<String, String> mItem;
	
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
	
	public HashMap<String, String> getItem() {
		return mItem;
	}
	
	public ResponDataObject () {
		mItem = new HashMap<String, String>();
		
	}

	 
}
