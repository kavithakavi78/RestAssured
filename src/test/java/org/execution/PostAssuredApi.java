package org.execution;

import org.json.simple.JSONObject;
import org.resources.Utility;
import org.testfile.ReadJsonFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostAssuredApi extends ReadJsonFile {

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

	@Test(dataProvider = "sample")
	public void testing(String data) {

		String users[] = data.split(",");
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();

		json.put("id", users[0]);
		json.put("name", users[1]);
		request.body(json.toJSONString());
		Response post = request.post("https://petstore.swagger.io/v2/pet");
		int code = post.getStatusCode();
		System.out.println(code);
		String body = post.getBody().asString();

		System.out.println("Status body " + body);
		long time = post.getTime();
		System.out.println("Time: " + time);

	}
}
