package org.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utility {
	 
	public static Properties prop;
	public static Response res;

	public static Properties loadProperty() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\RestAssured\\input\\config.properties");
		prop = new Properties();
		prop.load(fis);
		return prop;

	}
	public static Response getURI() {
		  res = RestAssured.get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
		return res;
		 
	}

}
