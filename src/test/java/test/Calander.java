package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Calander {
	
	public void hardWait(int seconds) {
		try {
			Thread.sleep(Duration.ofSeconds(seconds));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test_Calander() {

		System.setProperty("Webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		
		 driver.findElement(By.id("first_date_picker")).click();
		
		WebElement day = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td/a[contains(text(),'5')]"));
		day.click();
		hardWait(3);
		String selectedDate = driver.findElement(By.id("first_date_picker")).getText();

		Assert.assertEquals(selectedDate, "05/05/2025");
		driver.quit();
		

		
	}

	@Test
	public void test_Calander_sixth() {

		System.setProperty("Webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		

		WebElement calIcon = driver.findElement(By.className("ui-datepicker-trigger"));
		calIcon.click();
		
		WebElement day = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td/a[contains(text(),'5')]"));
		day.click();
		hardWait(3);
		WebElement sixthDate = driver.findElement(By.id("sixth_date_picker"));		
		String selectedDate = sixthDate.getText();

		System.out.println(selectedDate);
		Assert.assertEquals(selectedDate, "05/05/2025");
		driver.quit();
		
	}
	
}
