package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsPractice {

	@Test
	public void actionTest() {
		System.setProperty("Webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		
		By searchBox = By.id("twotabsearchtextbox");		
		driver.get("https://www.amazon.in/");
		act.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		act.moveToElement(driver.findElement(searchBox))
			.click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		driver.quit();

	}

}
