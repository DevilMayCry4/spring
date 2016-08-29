package com.cake.project.Model;
 
import com.fasterxml.jackson.annotation.JsonValue; 
 
public enum ResponCode
{
	success(200),
    needLogin(530),
    requireParam(531),
	userNameNotExist(532),
	wrongPassword(533),
	userAlreadyExist(534),
	excutionFail(535),
	;

    private int _value;

    private ResponCode(int value)
    {
        _value = value;
    }

    public int value()
    {
        return _value;
    }
    
    @JsonValue
    public int toValue() {
        return _value;
    }
}


