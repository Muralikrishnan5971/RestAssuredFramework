package com.mk.tests;

// static import of assetj 
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mk.Annotations.FrameworkAnnotations;
import com.mk.ApiRequestBuilder.RequestBuilder;
import com.mk.Reports.ExtentLogger;

import io.restassured.response.Response;

public class GetTests extends BaseTest {

	@Test(enabled = true)
	@FrameworkAnnotations(author = "Muralikrishnan", category = {"regression", "smoke", "getcall"})
	public void getEmployeeDetails() {

		Response response = RequestBuilder.buildGetRequest().get("/employees");

		response.prettyPrint();
		
		ExtentLogger.pass(response.prettyPrint());
		
		assertThat(response.getStatusCode()).isEqualTo(200);

		// $ indicated the root node

		System.out.println(response.jsonPath().getList("$").size());
		assertThat(response.jsonPath().getList("$").size()).isPositive().isGreaterThan(50);

	}

	@Test(enabled = true, dataProvider = "getRequestDataProvider")
	@FrameworkAnnotations(author = "Muralikrishnan", category = {"regression", "smoke", "getcall"})
	public void getSingleEmployeeDetail(Map<String, String> data) {

		Response response = RequestBuilder.buildGetRequest().pathParam("id", data.get("id")).get("/employees/{id}");

		response.prettyPrint();
		
		ExtentLogger.pass(response.prettyPrint());

		assertThat(response.jsonPath().getString("firstname")).isEqualTo(data.get("firstname").toLowerCase());
	}

	@DataProvider(name = "getRequestDataProvider")
	public Object[][] getData() {

		Object[][] data = new Object[3][1];

		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("id", "242");
		map1.put("firstname", "bambi");

		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("id", "751");
		map2.put("firstname", "miki");

		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("id", "836");
		map3.put("firstname", "gertha");

		data[0][0] = map1;
		data[1][0] = map2;
		data[2][0] = map3;

		return data;

	}
	
	@Test(enabled = false)
	@FrameworkAnnotations(author = "Muralikrishnan", category = {"regression", "smoke", "getcall"})
	public void getEmployeeTest(){
		
		Response response = RequestBuilder.buildGetRequest().get("/employees");

		response.prettyPrint();
		
		ExtentLogger.pass(response.prettyPrint());
		
		System.out.println(response.toString().length());
		
		assertThat(response.getStatusCode()).isEqualTo(200);
	}
}
