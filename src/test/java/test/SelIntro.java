package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntro {

	WebDriver driver;

	/**
	 * @param browser
	 */
	public SelIntro(String browser) {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.drive", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.drive", "src/test/resources/drivers/geckdriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.drive", "src/test/resources/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Plsease choose correct browser");
		}
	}

//	public static void main(String[] args) {
//		
//		String browser = "chrome";
//		WebDriver driver = null ;
//		
//		
//		
//		driver.get("https://www.selenium.dev/");
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getCurrentUrl());
//		
//		driver.quit();
//	}

}
