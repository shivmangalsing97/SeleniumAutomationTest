package test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DynamicTable {

	@Test
	public void test() {
		
		System.setProperty("web.driver.chrome", "src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js =  (JavascriptExecutor)driver ;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
		WebElement table = driver.findElement(By.id("example"));		
		js.executeScript("arguments[0].scrollIntoView()", table);
		
		WebElement nextButton = driver.findElement(By.xpath("//button[@aria-label='Next']"));
		System.out.println("IsEnable: " + nextButton.isEnabled());
		
		List<WebElement> headers = table.findElements(By.xpath("//thead/tr/th"));
		Iterator<WebElement> it = headers.iterator();
		
		while(it.hasNext()) {
			System.out.print(it.next().getText()+ "\t");
		}
		System.out.println("");
		
//		code to print all data from table using pagination
//		while(!driver.findElement(By.xpath("//button[@aria-label='Next']")).getAttribute("class").contains("disabled")) {
//			List<WebElement> tableRows = table.findElements(By.xpath("tbody/tr"));
//			for (WebElement tableRow: tableRows) {
//				List<WebElement> columns = tableRow.findElements(By.tagName("td"));
//				for(WebElement column: columns) {
//					System.out.print(column.getText()+ "\t");
//				}
//				System.out.println("");
//			}
//			driver.findElement(By.xpath("//button[@aria-label='Next']")).click();
//		}		
//		driver.findElement(By.xpath("//button[@aria-label='Last']")).click();
//		System.out.println("Disabled: " + driver.findElement(By.xpath("//button[@aria-label='Next']")).getAttribute("class").contains("disabled"));


		//		Code to print data of specific column
		while(!driver.findElement(By.xpath("//button[@aria-label='Next']")).getAttribute("class").contains("disabled")) {
			List<WebElement> tableRows = table.findElements(By.xpath("tbody/tr"));	
			for(WebElement tableRow: tableRows) {
				String name = tableRow.findElement(By.xpath("td[1]")).getText();
				if(name.equalsIgnoreCase("Quinn Flynn")) {
					List<WebElement> columns = tableRow.findElements(By.tagName("td"));
					for(WebElement column: columns)
						System.out.print(column.getText()+"\t");
				}
			}
			driver.findElement(By.xpath("//button[@aria-label='Next']")).click();
		}
		
		driver.quit();
		
	}
}
