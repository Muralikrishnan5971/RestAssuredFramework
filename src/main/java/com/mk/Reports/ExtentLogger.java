package com.mk.Reports;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.restassured.response.Response;

public final class ExtentLogger {

	private ExtentLogger() {

	}

	// by wrapping these methods in a seperate class, we have control on the methods
	// we expose.

	public static void pass(String message) {

		ReportManager.getTest().pass(message);
	}

	public static void fail(String message) {

		ReportManager.getTest().fail(message);
	}

	public static void info(String message) {

		ReportManager.getTest().info(message);
	}

	public static void logResponse(String response) {

		MarkupHelper.createCodeBlock(response, CodeLanguage.JSON);
	}
}
