package org.baseclass;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




public class BaseClass {
	

	RequestSpecification reqSpec;
	Response response;
	
	public void addHeader(String key, String value) {
	 reqSpec = RestAssured.given().header(key,value);

	}
	
	public void addHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);
		

	}
	
	public void addPathParam(String key, Object value) {
		reqSpec=reqSpec.pathParam(key, value);

	}
	public void addQueryParram(String key, Object value) {
	reqSpec=reqSpec.queryParam(key, value);
	
	}
	public void addBody(String body) {
		reqSpec=reqSpec.body(body);
	
	}
	
	// API--addbody-Object
		public void addBody(Object body) {
			reqSpec = reqSpec.body(body);
		}
		
	public void addBasicAuth(String username, String password) {
		reqSpec=reqSpec.auth().preemptive().basic(username, password);
		

	}
	public Response addReqType(String type, String endpoint){
		switch (type) {
		case "GET":
		 response = reqSpec.log().all().get(endpoint);
			break;
		case "POST":
			response=reqSpec.log().all().post(endpoint);
			break;
		case "DELETE":
			response=reqSpec.log().all().delete(endpoint);
			break;
		case "PATCH":
			response=reqSpec.log().all().patch(endpoint);
			break;
		case "PUT":
			response=reqSpec.log().all().put(endpoint);
			break;

		default:
			break;
		}
		return response;
	}
	
	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;

	}
	public String getResBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;

	}
	public String getResBodyAsString() {
		String asString = response.asString();
		return asString;

	}
	
	
}

