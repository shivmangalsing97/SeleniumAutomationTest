package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHeadLess {

	public static void main(String[] args) {
		
		ChromeOptions op = new ChromeOptions();
		op.addArguments("headless");
		
		WebDriver driver =  new ChromeDriver(op);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String title = driver.getTitle();
		System.out.println(title);

	}

}
