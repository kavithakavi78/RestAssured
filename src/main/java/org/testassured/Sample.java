package org.testassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Sample {
	@Test

	public void GetTest() {
		Response res = RestAssured.get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
		int code = res.getStatusCode();
		System.out.println("Ststus Code" + code);
		Assert.assertEquals(code, 200);
		String body = res.getBody().asString();
		System.out.println("Status body is " + body);
		Headers headers = res.getHeaders();
		System.out.println("Status header " + headers);
		String sL = res.getStatusLine();
		System.out.println("Status Line is" + sL);
		long time = res.getTime();
		System.out.println("Status Time is " + time);

	}

	@Test
	public void PostTest() {  
		RequestSpecification req = RestAssured.given();
		req.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("id", "545");
		json.put("name", "puppy");
		req.body(json.toJSONString());
		Response res = req.post("https://petstore.swagger.io/v2/pet");
		int code = res.getStatusCode();
		System.out.println("Status Code " + code);
		String body = res.getBody().asString();
		System.out.println("Status body is " + body);

	}

}
