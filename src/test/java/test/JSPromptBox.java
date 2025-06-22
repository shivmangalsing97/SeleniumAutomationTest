package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSPromptBox {
	WebDriver driver ;
	@BeforeMethod
	public void setUp() {
	    driver = new ChromeDriver();
	    ScreenshotListner.driver = driver; // Important!
	}
	
	@Test
	public void promptTest() {
	
	WebDriverManager.chromedriver().setup();
	JavascriptExecutor js = (JavascriptExecutor) driver ;

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	
	driver.findElement(By.xpath("//ul/li[3]/button")).click();
	String expectedText = "shiv";
	
	driver.switchTo().alert().sendKeys(expectedText);
	driver.switchTo().alert().accept();
	
	String enteredText = driver.findElement(By.id("result")).getText().split(":")[1].strip();

	Assert.assertEquals(enteredText, expectedText);
	System.out.println("Test Passed: Value Matched");
	
	driver.quit();
	
	
	
	}
}
