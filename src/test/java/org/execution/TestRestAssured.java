package org.execution;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.resources.Utility;
import org.testfile.ReadJsonFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestRestAssured extends ReadJsonFile {
	Utility uti;

	@Test

	public void get() throws IOException {
		uti = new Utility();
		uti.loadProperty();

		Response res = RestAssured.get(uti.prop.getProperty("get"));
		System.out.println("Ststus Code" + res.statusCode());
		Assert.assertEquals(res.statusCode(), 200);
		System.out.println("Status body is " + res.getBody().asString());
		System.out.println("Status header " + res.getHeaders());
		System.out.println("Status Line is" + res.statusLine());
		System.out.println("Status Time is " + res.getTime());

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
		Response res = request.post(uti.prop.getProperty("post"));
		System.out.println("Ststus Code" + res.statusCode());
		Assert.assertEquals(res.statusCode(), 200);
		System.out.println("Status body is " + res.getBody().asString());
		System.out.println("Status header " + res.getHeaders());
		System.out.println("Status Line is" + res.statusLine());
		System.out.println("Status Time is " + res.getTime());

	}

}
