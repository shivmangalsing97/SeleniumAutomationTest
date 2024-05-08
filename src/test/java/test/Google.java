package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {

	 public static void main(String[] args) {
//	 	System.setProperty("webdriver.chrome.driver", "");
	 	WebDriver driver = new ChromeDriver();
	 	driver.manage().window().maximize();		
	 }

}
