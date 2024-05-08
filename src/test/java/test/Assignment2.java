package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Assignment2 {

	@Test
	public void assignmentTwo() {
		System.setProperty("Webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Shiv Mangal");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("Shiv@example.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("exe@123");
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		
		Select select = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		select.selectByVisibleText("Male");
		driver.findElement(By.cssSelector("input[value='option1']")).click();
		driver.findElement(By.cssSelector("input[type='date']")).sendKeys("14/03/1999");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		System.out.println(driver.findElement(By.cssSelector("div.alert-success")).getText());
		
		
		try {
			Thread.sleep(3000);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		driver.quit();
		
		
	}

}
