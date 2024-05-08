package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicDropDown {

	
	@Test
	public void Test1() throws InterruptedException {
		
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement country= driver.findElement(By.id("autosuggest"));
		country.sendKeys("it");
		
		List<WebElement> options = driver.findElements(By.cssSelector("li[role=\"presentation\"] a"));
		for (WebElement option : options ) {
			if(option.getText().equalsIgnoreCase("italy")) {
				option.click();
			}
		}
		
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void Test2() throws InterruptedException {
		
		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement from = driver.findElement(By.cssSelector("input.select_CTXT"));
		from.click();   
		
		WebElement fromCity = driver.findElement(By.cssSelector("div[id='glsctl00_mainContent_ddl_originStation1_CTNR'] a[value='BLR']"));
		
		fromCity.click();
		System.out.println("From City: " + fromCity.getText());
		WebElement toCity = driver.findElement(By.cssSelector("div[id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] a[value='GAU']"));
		toCity.click();
		System.out.println("To City: " + toCity.getText());
		
		Thread.sleep(3000);
		driver.quit();
	}
	
}
