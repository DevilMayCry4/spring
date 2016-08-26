package com.cake.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
 
public enum ResponCode
{
	success(200),
    needLogin(530),
    requireParam(531);

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


