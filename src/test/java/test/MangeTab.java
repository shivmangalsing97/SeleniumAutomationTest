package test;

import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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
	
	@Test
	public void openNewTabs() {
		

		WebDriver driver = new ChromeDriver();

//		
//		driver.manage().window().maximize();
//		System.out.println("Browser Window Maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.get("https://www.google.com/");

		// 1. Using Action class
//		Actions actions = new Actions(driver);
//		actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).perform();
		
		//2. Using Selenium 4
		driver.switchTo().newWindow(WindowType.WINDOW).get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.close();

		//3. Using JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver ; 
		js.executeScript("window.open(\"https://rahulshettyacademy.com/AutomationPractice/\")");
		driver.close();
		
		
//		driver.quit();
		
	}
	

}
