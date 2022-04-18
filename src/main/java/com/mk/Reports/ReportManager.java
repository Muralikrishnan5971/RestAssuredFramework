package com.mk.Reports;

import com.aventstack.extentreports.ExtentTest;

public final class ReportManager {

	private ReportManager() {

	}

	private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();

	// default access modifier to restrict access outside the package
	
	static ExtentTest getTest() {

		return exTest.get();
	}

	static void setTest(ExtentTest test) {

		exTest.set(test);
	}
}
