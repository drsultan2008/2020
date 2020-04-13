package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			// Create object mapper
			ObjectMapper mapper = new ObjectMapper();
			// Read JSON file and map/convert to Java POJO
			// data/sample-lite.json
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			System.out.println("Fisrt name: "+student.getFirstName());
			System.out.println("Last name: "+student.getLastName());
			System.out.println("Address: "+ student.getAddress());
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
