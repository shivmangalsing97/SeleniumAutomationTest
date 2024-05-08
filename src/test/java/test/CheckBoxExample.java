package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxExample {

	@Test
	public void CheckBoxExampleTest() {
		
		System.setProperty("Webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement checkBox = driver.findElement(By.cssSelector("input[name='checkBoxOption1']"));
		List<WebElement> checkBoxs = driver.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println("Total number of Checkboxs are: " + checkBoxs.size());
		
		Assert.assertFalse(checkBox.isSelected());
		System.out.println("CheckBox is not Selected");
		checkBox.click();
		Assert.assertTrue(checkBox.isSelected());
		System.out.println("CheckBox is Selected");
		checkBox.click();
		Assert.assertFalse(checkBox.isSelected());
		System.out.println("CheckBox is not Selected");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		
	}

}
