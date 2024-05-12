package cucumber.utils;


import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.Iterator;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseFunctions {

	private static WebDriver driver;
	String browser;
	String server;
//	PropertiesFileHandler prop = new PropertiesFileHandler();
	DesiredCapabilities cap = new DesiredCapabilities();
	

	public void initializeBrowser() {
		System.out.println(
				"*************************************Session Started*****************************************");
		browser = PropertiesFileHandler.readConfigProperties("browser").toUpperCase();
		server = PropertiesFileHandler.readConfigProperties("server").toUpperCase();
		System.out.println("Server: " + server);
		System.out.println("Browser: " + browser);

		if (server.equalsIgnoreCase("local")) {
			System.out.println("Server found to be local");
			switch (Browser.valueOf(browser)) {
			case CHROME:
				System.setProperty("webdriver.chrome.drive", "src/test/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case FIREFOX:
				System.setProperty("webdriver.gecko.drive", "src/test/resources/drivers/geckdriver.exe");
				driver = new FirefoxDriver();
				break;
			case EDGE:
				System.setProperty("webdriver.edge.drive", "src/test/resources/drivers/msedgedriver.exe");
				driver = new EdgeDriver();
				break;
			case IE:
				driver = new InternetExplorerDriver();
				break;
			default:
				browser = Browser.CHROME.toString();
				System.setProperty("webdriver.chrome.drive", "src/test/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			}

		} else if (server.equalsIgnoreCase("remote")) {
			System.out.println("Server found to be remote");
			String seleniumServerHub = PropertiesFileHandler.readConfigProperties("seleniumServerHub");
			System.out.println("Selenium server hub URL: " + seleniumServerHub);
			switch (Browser.valueOf(browser)) {
			case CHROME:
				cap.setCapability("browserName", "chrome");
				break;
			case FIREFOX:
				cap.setCapability("browserName", "Firefox");
				break;
			case EDGE:
				cap.setCapability("browserName", "MicrosoftEdge");
				break;
			case IE:
				cap.setCapability("browserName", "InternetExplorer");
				break;
			default:
				browser = Browser.CHROME.toString();
				cap.setCapability("browserName", "chrome");
				break;
			}

			try {
				driver = new RemoteWebDriver(new URL(seleniumServerHub), cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	}

	public void endSession() {
		driver.quit();
		System.out.println(
				"*************************************Session Started*****************************************");
	}
	
	public void launchApplication(String url) {
		driver.get(url);
	}
	
	public WebElement element(By locator) {
		return driver.findElement(locator);
	}
	
	public WebElement element(String locator){
		String[] locatorArray = PropertiesFileHandler.readLocatorsProerties(locator).split(":");
		String locatorType = locatorArray[0];
		String locatorString = locatorArray[1];
		By element = null ;
		
		switch(locatorType) {
		case "name":
			element = By.name(locatorString);
			break;
		case "class":
			element = By.className(locatorString);
			break;
		case "id":
			element = By.id(locatorString);
			break;	
		case "tagName":
			element = By.tagName(locatorString);
			break;
		case "cssselector":
			element = By.cssSelector(locatorString);
			break;
		case "xpath":
			element = By.xpath(locatorString);
			break;
		default:
				System.out.println("Given locator type: " + locatorType + "is not recommended");
		}
		return driver.findElement(element);
	}
	
	
	/**
	 * Function to get list of WebElements Given By locator
	 * @param locator
	 * @return
	 */
	public List<WebElement> elements(By locator) {
		return driver.findElements(locator);
	}
	
	/**
	 * Function to halt Execution for given seconds
	 * @param seconds
	 */
	void hardWait(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logMessage(String msg) {
		System.out.println(msg);
	}
	
	public Actions moveToElement(WebElement element) {
		Actions act = new Actions(driver);
		return act.moveToElement(element);
	}
	
	public Set<String> getAllWindows(){
		return driver.getWindowHandles();
	}
	
	public void switchToWindowHavingTitle(Set<String> windows , String title ) {
		Iterator<String> it = windows.iterator();
		while(it.hasNext()) {
			String windowTitile = it.next();
			if(windowTitile.equalsIgnoreCase(title)) {
				driver.switchTo().window(windowTitile);
				return ;
			}
		}
		logMessage("Window having title: " + title + ", Not Found!");
	}
	
	public void switchToWindowHavingTitle(String window) {
		driver.switchTo().window(window);
	}
	
	public TakesScreenshot takeScreenShot() {
		return (TakesScreenshot) driver;
	}
	
	
}
