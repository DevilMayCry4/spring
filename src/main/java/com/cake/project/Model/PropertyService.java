package com.cake.project.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
 

public class PropertyService extends BaseService {
	class PorpertyRowMapper implements RowMapper<Property> {
		
	    @Override
	    public Property mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	Property property = new Property();
	    	property.setParentId(rs.getString("parentId"));
	    	property.setPropertyId(rs.getString("propertyId"));
	    	property.setPropertyDesc(rs.getString("propertyDesc"));
	    	property.setEnd(rs.getBoolean("isEnd"));
	    	property.setPropertyName(rs.getString("propertyName"));
	        return property;
	    }
 
	}
	
	public List<Property> getPropertyLsit(int cityId) {
		String query = String.format( "SELECT * FROM propertylist WHERE cityId = %d", cityId); 

		List<Property> properties  = jdbcTemplate.query(query,
				new PorpertyRowMapper());
		return properties; 
	}

}
