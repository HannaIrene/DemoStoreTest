package demoqastore.testproject.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class DataHandlers {
	public static String getDataFromProperty(String fileName, String key) {
		String value = null;
		try {
			File f = new File("./execution-data/" + fileName + ".properties");
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			value = (String) prop.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}
