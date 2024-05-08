package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment7 {
	@Test
	public void AssignmentSeven() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement table = driver.findElement(By.cssSelector("table[name='courses']"));
		js.executeScript("arguments[0].scrollIntoView()", table);
		List<WebElement> rows = driver.findElements(By.cssSelector("table[name='courses'] tr"));
		System.out.println("Rows: " + rows.size());
		System.out.println("columns: " + rows.get(1).findElements(By.tagName("td")).size());
		System.out.println("Row 2 data: ");
		List<WebElement> row2 = rows.get(2).findElements(By.tagName("td"));
		System.out.println(row2.get(0).getText() + "\t" + row2.get(1).getText() + "\t" + row2.get(2).getText());
		driver.quit();
	}

}
