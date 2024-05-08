package test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JSConfirmBox {

	@Test
	public void JSConfirmBoxTest() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver ; 
		
		driver.manage().window().maximize();
		System.out.println("Browser Window Maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("launched page Title: " + driver.getTitle());
		System.out.println("launched page URL: " + driver.getCurrentUrl());
		
		WebElement confirmbtn = driver.findElement(By.id("confirmbtn"));
		js.executeScript("arguments[0].scrollIntoView()", confirmbtn);
		System.out.println("Scroll Into View : Button " );
		
		
		confirmbtn.click();
		System.out.println("Confirm Box Poped up");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.switchTo().alert().dismiss();
		System.out.println("Confirm Box Rejected");
		
		driver.quit();
	}

}
