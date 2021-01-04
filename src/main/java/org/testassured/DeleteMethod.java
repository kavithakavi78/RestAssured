package org.testassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteMethod {
	@Test
	public void get() {
		RequestSpecification request = RestAssured.given();
		Response resp = request.get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
		int code = resp.getStatusCode();
		System.out.println("status Code:  " + code);
		String body = resp.getBody().asString();
		System.out.println("Get body: " + body);

	}
	public void delete() {
		RequestSpecification request = RestAssured.given();
		Response delete = request.delete("https://petstore.swagger.io/v2/pet/578");
		int code2 = delete.getStatusCode();
		System.out.println("delete code is: " + code2);
		
	}
	

}
