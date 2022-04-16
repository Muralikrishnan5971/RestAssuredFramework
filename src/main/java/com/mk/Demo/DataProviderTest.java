package com.mk.Demo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	// The advantages of using Data Provider
	// It consider every set of data as a seperate test result
	// 10 set of data is consider as 10 seperate tests and resuts are captured
	// accordingly

	// In case there is no name explicitly given for our data provider, in that case
	// method name is given

	@Test(dataProvider = "myDataProvider")
	public void dpTest(Map<String, String> map) {

		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("superpower"));
	}

	@DataProvider(name = "myDataProvider")
	public Object[][] getData() {

		// Object[][]
		// first index --> Number of time you want to execute the test
		// second index --> Number of parameters to the method

		// In order to reduce the no of parameters to the test methods, we can follow
		// the below approach

		Object[][] data = new Object[3][1];

		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("username", "Billy Batson");
		map1.put("password", "ilivjl");
		map1.put("superpower", "shazam");

		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("username", "Bruce Wayne");
		map2.put("password", "iluvsuperman");
		map2.put("superpower", "iamrich");

		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("username", "Prince Diana");
		map3.put("password", "iluvBruce");
		map3.put("superpower", "lassooftruth");

		// adding our map to our data oject

		data[0][0] = map1;
		data[1][0] = map2;
		data[2][0] = map3;

		return data;

	}
}
