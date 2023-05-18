package com.swagger;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SwaggerDoc {

	public static void main(String[] args) {
		RequestSpecification reqSpec;
	 reqSpec = RestAssured.given();
	 reqSpec.header("accept", "application/json");
	 Response response = reqSpec.get("https://omrbranch.com/api/stateList");
	 int statusCode = response.getStatusCode();
	 System.out.println(statusCode);
	 String asString = response.asString();
	 System.out.println(asString);
	 
	 String asPrettyString = response.asPrettyString();
	 System.out.println(asPrettyString);
	 
	 
	 
	}

}
