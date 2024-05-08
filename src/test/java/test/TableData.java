package test;

import java.util.List;
import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TableData {

	@Test
	public void TableDataTest(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver ; 
		
		driver.manage().window().maximize();
		System.out.println("Browser Window Maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("launched page Title: " + driver.getTitle());
		System.out.println("launched page URL: " + driver.getCurrentUrl());
		WebElement table = driver.findElement(By.xpath("//*[@name='courses']"));
		js.executeScript("arguments[0].scrollIntoView()", table);
		System.out.println("Scroll Into View : Table " );

		ArrayList<ArrayList<String>> Table = new ArrayList<ArrayList<String>>();
		List<WebElement> tableRows = table.findElements(By.xpath("tbody/tr"));
		
		for (WebElement tableRow : tableRows) {
			List<WebElement> tableDatas = tableRow.findElements(By.xpath("th | td"));
			ArrayList<String> data = new ArrayList<String>();
			for(WebElement tableData : tableDatas) {
				System.out.print(tableData.getText().trim()+ "\t\t");
				data.add(tableData.getText().trim());
			}
			System.out.println("");
			Table.add(data);
		}		
		System.out.println(Table.get(2).get(2));
		driver .quit();
	}

}
