package com.mk.Constants;

import lombok.Getter;

@Getter
public class FCwithSingleton {

	// creating framwwork constants class as Singleton class.
	// Creational design pattern

	private static FCwithSingleton INSTANCE = null;

	private FCwithSingleton() {

	}

	public static synchronized FCwithSingleton getInstance() {

		if (INSTANCE == null) {

			INSTANCE = new FCwithSingleton();
		}
		return INSTANCE;
	}

	private final static String RESOURCE = System.getProperty("user.dir");
	private String requestJsonFolderPath = RESOURCE + "/src/test/resources/jsonFolder/";
	private String responseJsonFolderPath = RESOURCE + "/responseJson/";
}
