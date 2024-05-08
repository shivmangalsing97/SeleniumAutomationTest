package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment4 {

	@Test
	public void AssignmentFour() {
		System.setProperty("Webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.findElement(By.cssSelector("div.example a")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parent = iter.next();
		String child = iter.next();
		
		driver.switchTo().window(child);
		String childText = driver.findElement(By.cssSelector("div.example h3")).getText();
		System.out.println(childText);

		driver.switchTo().window(parent);
		String parentText = driver.findElement(By.cssSelector("div.example h3")).getText();
		System.out.println(parentText);
		
		driver.quit();
		
	}

}
