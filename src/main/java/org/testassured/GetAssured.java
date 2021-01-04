package org.testassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GetAssured {
	@Test
	public void testResponse() {
		Response response = RestAssured.get(" ");
		int code = response.getStatusCode();
		System.out.println("status code" + code);
		Assert.assertEquals(code, 200);
		ResponseBody body = response.getBody();
		System.out.println("Response Body:" + body);
		String data = response.asString();
		System.out.println("Status data:" + data);
		System.out.println("Response Time: " + response.getTime());
		String contentType = response.getContentType();
		System.out.println("Response Content " + contentType);
		Headers headers = response.getHeaders();
		System.out.println("Header is "+headers);

	}

}
 