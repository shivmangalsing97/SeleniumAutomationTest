package test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JSAlertBox {

	@Test
	public void JSAlertBoxTest() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver ; 
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		System.out.println("Browser Window Maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("launched page Title: " + driver.getTitle());
		System.out.println("launched page URL: " + driver.getCurrentUrl());
		
		WebElement alertBtn = driver.findElement(By.id("alertbtn"));
		js.executeScript("arguments[0].scrollIntoView()", alertBtn);
		System.out.println("Scroll Into View : Button " );
		
		
		alertBtn.click();
		System.out.println("Alert Box Poped up");
//		wait.until(ExpectedConditions.alertIsPresent());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.switchTo().alert().accept();
		System.out.println("Alert Box Accepted");
		
		
		driver.quit();
		
	}

}
