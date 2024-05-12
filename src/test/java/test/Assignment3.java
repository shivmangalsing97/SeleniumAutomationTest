package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Assignment3 {

	@Test
	public void AssignmentThree() throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
//		Wait wait2 = new FluentWait(driver)
//				.withTimeout(Duration.ofSeconds(30))
//				.pollingEvery(Duration.ofSeconds(3));
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.name("password")).sendKeys("learning");
		
		driver.findElement(By.xpath("//input[@value='user']")).click();
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@id='okayBtn']")));
		WebElement selector = driver.findElement(By.cssSelector("select.form-control"));
		Select options = new Select(selector);
		options.selectByVisibleText("Consultant");
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("ProtoCommerce Home")));
		
		List<WebElement> buttons = driver.findElements(By.cssSelector("button.btn-info"));
		for (WebElement addToCart : buttons)
			addToCart.click();
		
		driver.findElement(By.partialLinkText("Checkout")).click();
		driver.findElement(By.cssSelector("button.btn-success")).click();
		
		Thread.sleep(3000);
		
		js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("div.checkbox input#checkbox2")) );
//		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("div.checkbox input#checkbox2"))));
//		driver.findElement(By.cssSelector("div.checkbox input#checkbox2")).click();
		
		driver.findElement(By.id("country")).sendKeys("india");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.suggestions a")));
		driver.findElement(By.cssSelector("div.suggestions a")).click();
		driver.findElement(By.cssSelector("input.btn-success")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert-success")));
		System.out.println(driver.findElement(By.cssSelector("div.alert-success")).getText());
		
		driver.quit();
	}

}
