package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GridPractice {
	
	WebDriver driver ;
	

	@BeforeTest
	public void GridPracticeBeforeTest() throws MalformedURLException {
		
//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setBrowserName("edge");
//		caps.setPlatform(Platform.WINDOWS);
		
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("C:/Users/shiv.mangal/AppData/Local/Mozilla Firefox/firefox.exe");
		
		String url = "http://192.168.1.6:4444/wd/hub" ;
		driver = new RemoteWebDriver(new URL(url), options );
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	
	@Test
	public void GridPracticeTest() {
		
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
