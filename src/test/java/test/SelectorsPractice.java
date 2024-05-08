package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SelectorsPractice {

	@Test
	public void SelectorsPracticeTest() {
		SelIntro obj = new SelIntro("firefox");
		WebDriver driver  = obj.driver ;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Shiv");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("Shiv@1234");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.error")));
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.quit();
	}

}
