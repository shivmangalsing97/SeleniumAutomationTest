package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Actions2 {
	
	@Test
	public void DragAndDropTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/droppable/");
		WebElement frame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(draggable, droppable).perform();
		
//		try {
//			Thread.sleep(30000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		driver.quit();
	}
	
	@Test
	public void ClickAndHoldTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/droppable/");
		WebElement frame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(draggable).clickAndHold().moveToElement(droppable).release().perform();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}
	
	@Test
	public void MoveByOffSet() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/resizable/");
		WebElement frame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		
		WebElement draggable = driver.findElement(By.cssSelector("div#resizable div:nth-child(4)"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(draggable).clickAndHold().moveByOffset(40, 40).release().perform();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}
	
}
