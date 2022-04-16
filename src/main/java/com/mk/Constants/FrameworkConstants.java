package com.mk.Constants;

import lombok.Getter;

public class FrameworkConstants {

	private final static String RESOURCE = System.getProperty("user.dir");

	// In case of static variables, the lombok annotations should be given in field
	// level

	private static @Getter String requestJsonFolderPath = RESOURCE + "/src/test/resources/jsonFolder/";
	private static @Getter String responseJsonFolderPath = RESOURCE + "/responseJson/";
	private static @Getter String configPropertiesFilePath = RESOURCE + "/src/test/resources/config.properties";
	private static @Getter String jsonSchemaFilePath = "jsonSchemaFolder/schema.json";
}
