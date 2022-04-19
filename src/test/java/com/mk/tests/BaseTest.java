package com.mk.tests;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.mk.Reports.ExtentLogger;
import com.mk.Reports.GenerateReport;

public class BaseTest {

	@BeforeSuite
	public void setUpSuite() {

		
	}

	@AfterSuite
	public void tearDownSuite() {

		
	}

	@BeforeMethod
	public void setUpMethod(Method name) {

		
	}

	@AfterMethod
	public void tearDownMethodITest(ITestResult result) {

		
	}
}
