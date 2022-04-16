package com.mk.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class GenerateReport {

	private GenerateReport() {

	}

	private static ExtentReports report;
	private static ExtentTest test; // is not Thread Safe

	public static void initReports() {

		// Before Suite
		report = new ExtentReports();
		ExtentSparkReporter sparkReport = new ExtentSparkReporter("index.html");
		report.attachReporter(sparkReport);
	}

	public static void endReports() {

		// After Suite
		report.flush();

	}

	public static void createTest(String name) {

		test = report.createTest(name);

		ReportManager.setTest(test);
	}

}
