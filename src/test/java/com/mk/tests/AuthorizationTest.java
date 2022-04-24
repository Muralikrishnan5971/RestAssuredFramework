package com.mk.tests;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AuthorizationTest {

	
	@Test(enabled = false)
	public void basicAuthTest(){
		
		Response response = given()
//				.auth()
//				.basic("postman", "password")
				.header("Authorization", "Basic cG9zdG1hbjpwYXNzd29yZA==")	// both does the same, as did in postman
				.log()
				.all()
				.get("https://postman-echo.com/basic-auth");
		
		response.prettyPrint();
	}
	
	@Test(enabled = false)
	public void getAllWorkspaceInPostman(){
		
		Response response = given()
		.header("X-Api-Key", "PMAK-62619ae76f0b931a8d63f0e3-a420a5377ac9df59ad157699bd5ed85503")
		.log()
		.all()
		.get("https://api.getpostman.com/workspaces");
		
		response.prettyPrint();
	}
	
	@Test(enabled = false)
	public void getMyGitHubRepos() {
		
		Response response = given()
				.header("Authorization", "Bearer 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")
				.queryParam("affiliation", "owner")
				.log()
				.all()
				.get("https://api.github.com/user/repos");
		
		response.prettyPrint();
	}
	
	
	
	
}
