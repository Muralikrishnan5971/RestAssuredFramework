package com.mk.tests;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.mk.Annotations.FrameworkAnnotations;
import com.mk.ApiRequestBuilder.RequestBuilder;
import com.mk.Constants.FCwithSingleton;
import com.mk.Constants.FrameworkConstants;
import com.mk.Pojos.Employee;
import com.mk.Pojos.FavFoods;
import com.mk.Pojos.Marks;
import com.mk.Reports.ExtentLogger;
import com.mk.RequestUtils.ApiUtils;
import com.mk.RequestUtils.RandomUtils;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostTest extends BaseTest {

	@Test(enabled = true)
	@FrameworkAnnotations(author = "Muralikrishnan", category = {"regression", "smoke", "postcall"})
	public void postNewEmployee() {

		// Create a new employee in db using a post call
		// construct requet body using POJO classes and Lonmbok builder

		// AAA Principle

		// AARANGE

		List<String> dinnerList = new ArrayList<String>();
		dinnerList.add("pulka");
		dinnerList.add("milk");

		FavFoods favFoods = FavFoods.builder().setBreakFast("Idly").setLunch("Briyani").setDinner(dinnerList).build();

		List<String> jobsList = new ArrayList<String>();
		jobsList.add("manual qa");
		jobsList.add("automation tester");

		Marks sem1Marks = Marks.builder().setEnglish(54).setTamil(47).build();
		Marks sem2Marks = Marks.builder().setEnglish(85).setTamil(69).build();

		List<Marks> marksList = new ArrayList<Marks>();
		marksList.add(sem1Marks);
		marksList.add(sem2Marks);

		Employee employee = Employee.builder().setId(RandomUtils.getRandomId()).setFirstname(RandomUtils.getFirstName())
				.setLastname(RandomUtils.getLastName()).setEmail(RandomUtils.getEmail()).setFavfoods(favFoods)
				.setJobs(jobsList).setMarks(marksList).build();

		// ACTION

		RequestSpecification responseSpecification = RequestBuilder.buildPostRequest().body(employee);
				
		// To log the response to our report
		
		ExtentLogger.logRequest(responseSpecification);
		
		Response response = responseSpecification.post("/employees");

		response.prettyPrint();

		ExtentLogger.pass(response.prettyPrint());

		// ASSERTION

		Assertions.assertThat(response.getStatusCode()).as("Validating the Response Code for POST call").isEqualTo(201);

		// Schema Validation
		// classpath means -> src/main/resources or src/test/resources

		response.then()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath(FrameworkConstants.getJsonSchemaFilePath()));

	}

	@Test(enabled = false)
	@FrameworkAnnotations(author = "Muralikrishnan", category = {"regression", "smoke", "postcall"})
	public void postNewEmployeeUsingExternalFile(Method method) {

		// reading the request body from an external json file
		String requestBodyString = ApiUtils
				.readJsonAndGetAsString(FrameworkConstants.getRequestJsonFolderPath() + "/request.json")
				.replace("fname", RandomUtils.getFirstName()).replace("1", String.valueOf(RandomUtils.getRandomId()));

		Response response = RequestBuilder.buildPostRequest().body(requestBodyString).post("/employees");

		response.prettyPrint();

		ExtentLogger.pass(response.prettyPrint());

		// writing the respone in an external json file
		ApiUtils.storeResponseAsJsonFile(
				FrameworkConstants.getResponseJsonFolderPath() + method.getName() + "response.json", response);

		Assertions.assertThat(response.getStatusCode()).as("Validating the Response Code for POST call").isEqualTo(201);

	}

	// reading the framework constants from the Singleton class

	@Test(enabled = false)
	@FrameworkAnnotations(author = "Muralikrishnan", category = {"regression", "smoke", "postcall"})
	public void postNewEmployeeUsingExternalFileSingleton(Method method) {

		// reading the request body from an external json file
		String requestBodyString = ApiUtils
				.readJsonAndGetAsString(FCwithSingleton.getInstance().getRequestJsonFolderPath() + "/request.json")
				.replace("fname", RandomUtils.getFirstName()).replace("1", String.valueOf(RandomUtils.getRandomId()));

		Response response = RequestBuilder.buildPostRequest().body(requestBodyString).post("/employees");

		response.prettyPrint();

		// writing the respone in an external json file
		ApiUtils.storeResponseAsJsonFile(
				FCwithSingleton.getInstance().getResponseJsonFolderPath() + method.getName() + "response.json",
				response);

		Assertions.assertThat(response.getStatusCode()).as("Validating the Response Code for POST call").isEqualTo(201);

	}

}
