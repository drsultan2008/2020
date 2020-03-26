package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private String favoriteCountry;
	
	private String[] operatingSystem;
	
	private LinkedHashMap<String,String> countryOptions;
	private LinkedHashMap<String,String> favoriteRadios;
	
	
	Student(){
		countryOptions = new LinkedHashMap<>();
		favoriteRadios = new LinkedHashMap<>();
		
		countryOptions.put("VI", "VietNam");
		countryOptions.put("US", "United State");
		
		favoriteRadios.put("Java", "Java");
		favoriteRadios.put("C","C");
		favoriteRadios.put("Python", "Python");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteCountry() {
		return favoriteCountry;
	}

	public void setFavoriteCountry(String favoriteCountry) {
		this.favoriteCountry = favoriteCountry;
	}

	public LinkedHashMap<String, String> getFavoriteRadios() {
		return favoriteRadios;
	}

	public void setFavoriteRadios(LinkedHashMap<String, String> favoriteRadios) {
		this.favoriteRadios = favoriteRadios;
	}

	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}

	public String[] getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	
	

}

