package test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SRKTest {

	@Test
	public void SRKTestOne() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/droppable/");
		
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(frame);
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement dropable = driver.findElement(By.id("droppable"));
		Actions act = new Actions(driver);
		
		act.dragAndDrop(draggable, dropable).perform();
		
		driver.quit();

	}

}
