package org.testfile;

import java.io.IOException;

import org.resources.Utility;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReadDataFromJson extends Utility {
	
	@Test
	
	public void get() throws IOException {
		String req = loadProperty().getProperty("get");
	    Response res = RestAssured.get(req);
	    int code = res.getStatusCode();
	    System.out.println(code);
		
	}
	
}
