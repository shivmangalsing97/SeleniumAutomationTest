package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestLongTime {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("Watches");
		driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
		String text = driver.findElement(By.xpath("//div[@data-component-type='s-search-result'][1]/..//h2/a/span")).getText();
		System.out.println(text);
		driver.quit();
		
	}

}
