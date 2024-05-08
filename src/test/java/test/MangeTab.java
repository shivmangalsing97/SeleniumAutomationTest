package test;

import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MangeTab {

	@Test
	public void MangeTabTest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver ; 
		
		driver.manage().window().maximize();
		System.out.println("Browser Window Maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("launched page Title: " + driver.getTitle());
		System.out.println("launched page URL: " + driver.getCurrentUrl());
		
		WebElement btn = driver.findElement(By.id("opentab"));
		js.executeScript("arguments[0].scrollIntoView()", btn);
		System.out.println("Scroll Into View : Button " );
		
		String parent = driver.getWindowHandle();
		
		btn.click();
		System.out.println("clicked on Button ");
		
		ArrayList <String> newTabs = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(newTabs.get(1));
		System.out.println("Switched Tab Title: " + driver.getTitle());
		System.out.println("Switched Tab URL: " + driver.getCurrentUrl());
		
		driver.close();
		driver.switchTo().window(parent);
		System.out.println("Switched Tab Title: " + driver.getTitle());
		System.out.println("Switched Tab URL: " + driver.getCurrentUrl());
		
		driver.quit();
	}

}
