package com.mk.RequestUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.mk.Constants.FrameworkConstants;
import com.mk.Enums.ConfigProperty;

public final class PropertyUtils {

	private PropertyUtils() {

	}

	// read the content from property file and store it in a Hash map
	// Good practice is always to read the properties once and store it some better
	// java collections

	private static Properties properties = new Properties();
	private static Map<String, String> MAP = new HashMap<String, String>();

	static {

		// try with resources block

		try (FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigPropertiesFilePath())) {

			properties.load(fis);

		} catch (IOException e1) {

			e1.printStackTrace();

			// In case of exception, we need to stop the program
			// we can also throw new RunTime Exception

			System.exit(0);
		}

		properties.entrySet().forEach(e -> MAP.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));

	}

	public static String getBaseUriValue(ConfigProperty congifProperty) {

		return MAP.get(congifProperty.name().toLowerCase());
	}
}
