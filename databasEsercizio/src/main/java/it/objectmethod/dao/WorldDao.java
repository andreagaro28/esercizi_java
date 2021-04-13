package it.objectmethod.dao;

import java.sql.SQLException;
import java.util.List;

import it.objectmethod.model.City;
import it.objectmethod.model.Country;
import it.objectmethod.model.CountryContinent;

public interface WorldDao {
	public City getCityByName(String name) throws SQLException;

	List<Country> getCountryByContinentName(String name, String continent) throws SQLException;
	
	List<String> getContinent() throws SQLException; 
	
	List<CountryContinent> getCountryByContinentList(String name) throws SQLException;
	
	List<City> getCityByCode(String code) throws SQLException;

}
