package com.mk.tests;

// static import of assetj 
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.mk.ApiRequestBuilder.RequestBuilder;

import io.restassured.response.Response;

public class GetTests {

	@Test(enabled = false)
	public void getEmployeeDetails() {

		Response response = RequestBuilder.buildGetRequest().get("/employees");

		response.prettyPrint();

		assertThat(response.getStatusCode()).isEqualTo(200);

		// $ indicated the root node

		System.out.println(response.jsonPath().getList("$").size());
		assertThat(response.jsonPath().getList("$").size()).isPositive().isGreaterThan(50);

	}

	@Test
	public void getSingleEmployeeDetail() {

		Response response = RequestBuilder.buildGetRequest().pathParam("id", 290).get("/employees/{id}");

		response.prettyPrint();

		assertThat(response.jsonPath().getString("lastname")).isEqualTo("Pollich");
	}
}
