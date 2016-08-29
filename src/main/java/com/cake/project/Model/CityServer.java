package com.cake.project.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
  
import org.springframework.jdbc.core.RowMapper;

import com.cake.project.Model.BaseService;
import com.cake.project.Model.City;

public class CityServer extends BaseService {

 

	class CityRowMapper implements RowMapper<City> {
	    @Override
	    public City mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	City city = new City();
	    	city.cityName = rs.getString("cityName");
	    	city.cityId = rs.getInt("cityId");
	        return city;
	    }
 
	}
	
	public List<City> getCitylist() {
		String query = "SELECT * FROM city;"; 

		List<City> cities  = jdbcTemplate.query(query,
				new CityRowMapper());
		City city = cities.get(0);
		String string = city.cityName;
		logger.info(string);

		return cities; 
	}

}
