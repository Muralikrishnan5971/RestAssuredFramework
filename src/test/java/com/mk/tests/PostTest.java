package com.mk.tests;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.mk.ApiRequestBuilder.RequestBuilder;
import com.mk.Pojos.Employee;
import com.mk.Pojos.FavFoods;
import com.mk.Pojos.Marks;
import com.mk.RequestUtils.RandomUtils;

import io.restassured.response.Response;

public class PostTest {

	@Test
	public void postNewEmployee() {

		// Create a new employee in db using a post call
		// construct requet body using POJO classes and Lonmbok builder

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

		Employee employee = Employee.builder().setId(RandomUtils.getRandomId())
				.setFirstname(RandomUtils.getFirstName())
				.setLastname(RandomUtils.getLastName())
				.setEmail(RandomUtils.getEmail())
				.setFavfoods(favFoods)
				.setJobs(jobsList)
				.setMarks(marksList)
				.build();

		Response response = RequestBuilder.buildPostRequest()
				.body(employee)
				.post("/employees");

		response.prettyPrint();
		Assertions.assertThat(response.getStatusCode()).as("Validating the Response Code for POST call").isEqualTo(201);

	}
}
