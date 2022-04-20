package com.mk.tests;

import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.Test;

import com.mk.Annotations.FrameworkAnnotations;
import com.mk.Pojos.Employee;
import com.mk.Reports.ExtentLogger;
import com.mk.RequestUtils.ApiUtils;
import com.mk.RequestUtils.RandomUtils;

import static com.mk.ApiRequestBuilder.RequestBuilder.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AssignmentTest {


	@Test
	@FrameworkAnnotations(author = "Muralikrishnan", category = "Assignment")
	public void assignmentTestCall() {
		
		Response response = buildGetRequest().get("/employees");
		int size = response.jsonPath().getList("$").size();
		
		Employee employee = Employee.builder()
		.setFirstname(RandomUtils.getFirstName())
		.setLastname(RandomUtils.getLastName())
		.setId(RandomUtils.getRandomId()).build();
		
		RequestSpecification requestSpecification = buildPostRequest().body(employee);
		ExtentLogger.logRequest(requestSpecification);
		
		Response postResponse = requestSpecification.post("/employees");
		
		assertThat(buildGetRequest().get("/employees").jsonPath().getList("$").size()).isEqualTo(size+1);
		
		ApiUtils.storeResponseAsJsonFile("putResponse.txt", postResponse);
		
		// we need to write seperate method for delete call, for time being using the existing same method
		buildGetRequest().pathParam("id", employee.getId()).delete("/employees/{id}");
		
		assertThat(buildGetRequest().get("/employees").jsonPath().getList("$").size()).isEqualTo(size);
		
	}
}
