package com.mk.ApiRequestBuilder;

import static io.restassured.RestAssured.*;

import com.mk.Enums.ConfigProperty;
import com.mk.RequestUtils.PropertyUtils;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class RequestBuilder {

	private RequestBuilder(){
		
	}
	
	
	public static RequestSpecification buildGetRequest() {
		
		return given()
				.baseUri(PropertyUtils.getBaseUriValue(ConfigProperty.BASEURI))
				.log()
				.all();
	}
	
	public static RequestSpecification buildPostRequest() {
		
		return buildGetRequest()
				.contentType(ContentType.JSON);
	}
}
