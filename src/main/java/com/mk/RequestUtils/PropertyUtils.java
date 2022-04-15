package com.mk.RequestUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertyUtils {

	private PropertyUtils() {

	}

	// read the content from property file and store it in a Hash map
	// Good practice is always to read the properties once and store it some better
	// java collections

	private static Properties properties = new Properties();
	private static Map<String, String> MAP = new HashMap<String, String>();

	public static void readPropertyFile() {

		try {

			FileInputStream fis = new FileInputStream("");

			properties.load(fis);

		} catch (FileNotFoundException e1) {

			e1.printStackTrace();

		} catch (IOException e1) {

			e1.printStackTrace();
		}

		properties.entrySet().forEach(e -> MAP.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));

	}

	public static String getBaseUriValue(String key) {

		return MAP.get(key);
	}

}
