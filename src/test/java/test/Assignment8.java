package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Assignment8 {

	@Test
	public void AssignmentEight() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("input#autocomplete")).sendKeys("uni");
		List<WebElement> suggestions = driver.findElements(By.cssSelector("ul li.ui-menu-item"));
		for(WebElement suggestion : suggestions) {
			if(suggestion.getText().equalsIgnoreCase("United Kingdom (UK)")) {
				act.moveToElement(suggestion).click().perform() ;
				break ;
			}
		}
		driver.quit();
	}

}
