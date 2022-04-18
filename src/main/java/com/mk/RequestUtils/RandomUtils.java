package com.mk.RequestUtils;

public final class RandomUtils {

	private RandomUtils() {

	}

	// this layer acts as business layer
	// here we can do our additional business logic

	public static int getRandomId() {

		return FakerUtils.getNumber(1000, 1500);
	}

	public static String getFirstName() {

		return FakerUtils.getFirstName().toLowerCase();
	}

	public static String getLastName() {

		return FakerUtils.getLastName().toLowerCase();
	}

	public static String getEmail() {

		return FakerUtils.getEmailName() + "@gmail.com";
	}
}
