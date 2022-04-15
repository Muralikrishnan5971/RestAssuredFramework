package com.mk.ApiRequestBuilder;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class RequestBuilder {

	private RequestBuilder(){
		
	}
	
	
	public static RequestSpecification buildGetRequest() {
		
		return given()
				.baseUri("http://localhost:3000")
				.log()
				.all();
	}
	
	public static RequestSpecification buildPostRequest() {
		
		return buildGetRequest()
				.contentType(ContentType.JSON);
	}
}
