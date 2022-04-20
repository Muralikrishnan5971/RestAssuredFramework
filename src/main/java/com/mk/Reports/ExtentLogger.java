package com.mk.Reports;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.restassured.http.Header;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public final class ExtentLogger {

	private ExtentLogger() {

	}

	// by wrapping these methods in a seperate class, we have control on the methods
	// we expose.

	public static void pass(String message) {

		ReportManager.getTest().pass(message);
	}

	public static void fail(String message) {

		ReportManager.getTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	public static void info(String message) {

		ReportManager.getTest().info(message);
	}

	public static void logResponse(String response) {

		MarkupHelper.createCodeBlock(response, CodeLanguage.JSON);
	}
	
	public static void logRequest(RequestSpecification specification) {
		
		QueryableRequestSpecification query = SpecificationQuerier.query(specification); // this method queries our request
		
		info("Request Details Below");
		
		ReportManager.getTest().info(MarkupHelper.createCodeBlock(query.getBody(), CodeLanguage.JSON));
		
		for (Header header : query.getHeaders()) {
			
			info(header.getName() +":"+ header.getValue());
		}
		
	}
}
