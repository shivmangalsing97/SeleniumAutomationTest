package cucumber.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesFileHandler  {
	
	public static String readConfigProperties(String propertyName){
		String propertyValue = null ;
		try {
			FileReader newFile = new FileReader("src/test/resources/TestData/config.properties");
			Properties newProp = new Properties();
			newProp.load(newFile);
			propertyValue = newProp.getProperty(propertyName);
			newFile.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return propertyValue;
	}
	
	public static String readURLProerties(String propertyName) {
		String propertyValue = null;
		try {
			Properties newProp = new Properties();
			FileReader newFile = new FileReader("src/test/resources/TestData/url.properties");;
			newProp.load(newFile);
			propertyValue = newProp.getProperty(propertyName);
			newFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propertyValue;
		
	}
	
	public static String readLocatorsProerties(String propertyName) {
		String propertyValue = null;
		try {
			Properties newProp = new Properties();
			FileReader newFile = new FileReader("src/test/resources/TestData/locators.properties");;
			newProp.load(newFile);
			propertyValue = newProp.getProperty(propertyName);
			newFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propertyValue;
		
	}

}
