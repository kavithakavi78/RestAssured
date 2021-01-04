package org.testassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostAssured {

	@Test
	public void PostMethod() {
		RequestSpecification req = RestAssured.given();
		req.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("id", "14");
		json.put("email", "vkkkavi78@gmail.com");
		json.put("first_name", "Kavi");
		json.put("last_name", "k");
		req.body(json.toJSONString());
		Response res = req.post("https://reqres.in/api/users?page=2");
		int code = res.getStatusCode();
		System.out.println("Status Code " + code);
		Assert.assertEquals(code, 201);

		String statusLine = res.getStatusLine();
		System.out.println("status line " + statusLine);

		String st = res.asString();
		System.out.println("data is " + st);
		Response delete = req.delete("https://reqres.in/api/users?id=4");
		int code2 = delete.getStatusCode();
		System.out.println("delete code is: " + code2);

	}

}
