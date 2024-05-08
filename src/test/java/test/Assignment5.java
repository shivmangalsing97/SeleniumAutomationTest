package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment5 {

	@Test
	public void AssignmentFive() {
		System.setProperty("Webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		By topframe = By.xpath("//frame[@name='frame-top']");
		By middleFrame = By.xpath("//frame[@name='frame-middle']");
		By content = By.id("content");
		
		
		driver.switchTo().frame(driver.findElement(topframe));
		driver.switchTo().frame(driver.findElement(middleFrame));
		
		String txt = driver.findElement(content).getText();
		System.out.println(txt);

		driver.quit();
		
	}

}
