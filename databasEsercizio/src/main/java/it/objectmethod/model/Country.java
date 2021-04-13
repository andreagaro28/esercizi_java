package it.objectmethod.model;

public class Country {
	
	private String code;
	private String name;
	private String continent;
	private Integer population;
	private float surfaceArea;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getcontinent() {
		return continent;
	}
	public void setcontinent(String pontinent) {
		this.continent = pontinent;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public float getSurfaceArea() {
		return surfaceArea;
	}
	public void setSurfaceArea(float surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
}
