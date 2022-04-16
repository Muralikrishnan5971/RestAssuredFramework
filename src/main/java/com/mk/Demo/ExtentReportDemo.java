package com.mk.Demo;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

	@Test
	public void extentReportTest() {

		// Before Suite
		ExtentReports report = new ExtentReports();
		ExtentSparkReporter sparkReport = new ExtentSparkReporter("index.html");
		report.attachReporter(sparkReport);

		// First Test
		ExtentTest extentTest1 = report.createTest("First Test");
		extentTest1.log(Status.PASS, "Logging the my first test as PASSED");

		// Second Test
		ExtentTest extentTest2 = report.createTest("Second Test");
		extentTest2.log(Status.PASS, "Logging the my second test as PASSED");
		
		// After every test case check whether pass or fail and need to log in the report

		// After Suite
		report.flush();
	}
}
