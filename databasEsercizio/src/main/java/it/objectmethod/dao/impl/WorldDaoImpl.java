package it.objectmethod.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.objectmethod.dao.WorldDao;
import it.objectmethod.model.City;
import it.objectmethod.model.Country;
import it.objectmethod.model.CountryContinent;
import it.objectmethod.util.ConnectionFactory;

public class WorldDaoImpl implements WorldDao{

	@Override
	public City getCityByName(String name) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		City city = null;

		String querySql = "SELECT * FROM city WHERE UPPER(Name) = ?";

		PreparedStatement stmt = conn.prepareStatement(querySql);
		stmt.setString(1, name);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			city = new City();
			city.setId(rs.getInt("ID"));
			city.setCountryCode(rs.getString("CountryCode"));
			city.setName(rs.getString("Name"));
			city.setPopulation(rs.getInt("Population"));
			city.setDistrict(rs.getString("District"));
		}
		rs.close();
		stmt.close();
		conn.close();

		return city;


	}

	@Override
	public List<Country> getCountryByContinentName(String name, String continent) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		Country country = null;
		List<Country> countryList= new ArrayList<Country>();

		String querySql = "SELECT Name, Continent, Population, SurfaceArea, Code FROM country \r\n"
				+ "WHERE UPPER(('' = ? OR Name = ?) \r\n"
				+ "AND  ('' = ? OR Continent = ?))\r\n"
				+ "";

		PreparedStatement stmt = conn.prepareStatement(querySql);
		stmt.setString(1, name);
		stmt.setString(2, name);
		stmt.setString(3, continent);
		stmt.setString(4, continent);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			country = new Country();
			country.setCode(rs.getString("Code"));
			country.setName(rs.getString("Name"));
			country.setPopulation(rs.getInt("Population"));
			country.setcontinent(rs.getString("Continent"));
			country.setSurfaceArea(rs.getFloat("SurfaceArea"));
			countryList.add(country);
		}


		rs.close();
		stmt.close();
		conn.close();
		return countryList;
	}

	@Override
	public List<String> getContinent() throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		List<String> continentList= new ArrayList<String>();

		String querySql = "SELECT Continent FROM country\r\n"
				+ "GROUP BY Continent ";


		PreparedStatement stmt = conn.prepareStatement(querySql);

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			continentList.add(rs.getString("Continent"));
		}

		rs.close();
		stmt.close();
		conn.close();
		return continentList;
	}


	@Override
	public List<CountryContinent> getCountryByContinentList(String name) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		List<CountryContinent> countryList = new ArrayList<>();
		CountryContinent country = null;
		String querySql = "SELECT Name, Population, Code FROM country "
				+ "WHERE UPPER(Continent) = ?";

		PreparedStatement stmt = conn.prepareStatement(querySql);
		stmt.setString(1, name);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			country = new CountryContinent();
			country.setName(rs.getString("Name"));
			country.setCode(rs.getString("Code"));
			country.setPopulation(rs.getInt("Population"));
			countryList.add(country);
		}
		rs.close();
		stmt.close();
		conn.close();

		return countryList;
	}

	@Override
	public List<City> getCityByCode(String code) throws SQLException {
		Connection conn = ConnectionFactory.getConnection();
		List<City> cityList = new ArrayList<>();
		City city = null;

		String querySql = "SELECT Name, Population FROM city WHERE UPPER(CountryCode) = ?";
		
		PreparedStatement stmt = conn.prepareStatement(querySql);
		stmt.setString(1, code);
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			city = new City();
			city.setName(rs.getString("Name"));
			city.setPopulation(rs.getInt("Population"));
			cityList.add(city);
		}
		rs.close();
		stmt.close();
		conn.close();

		return cityList;
	}


}
