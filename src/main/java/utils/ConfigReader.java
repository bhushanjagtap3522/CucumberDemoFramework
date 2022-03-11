package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static String getProperty(String property) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("src//main//java//config//Config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop.getProperty(property);
		
	}

}
