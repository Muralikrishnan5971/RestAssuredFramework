package com.mk.Reports;

import com.aventstack.extentreports.ExtentTest;

public final class ReportManager {

	private ReportManager() {

	}

	private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();

	public static ExtentTest getTest() {

		return exTest.get();
	}

	public static void setTest(ExtentTest test) {

		exTest.set(test);
	}
}
