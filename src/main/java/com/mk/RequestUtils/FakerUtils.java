package com.mk.RequestUtils;

import com.github.javafaker.Faker;

public final class FakerUtils {

	private FakerUtils() {

	}

	// Any changes related to the third party library can be done here.

	private static final Faker faker = new Faker();

	// restricting the scope of these methods to package level by using default access modifer
	
	static int getNumber(int startValue, int endValue) {

		return faker.number().numberBetween(startValue, endValue);
	}

	static String getFirstName() {

		return faker.name().firstName();
	}

	static String getLastName() {

		return faker.name().lastName();
	}

	static String getEmailName() {

		return faker.artist().name();
	}
}
