package cucumber.hooksteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.utils.PropertiesFileHandler;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HooksSteps {

	WebDriver driver = null;
	
	@Before(order=0)
	public void setupBrowser() {
		
		System.out.println(
				"*************************************Session Started*****************************************");
		System.out.println("Server: local");
		System.out.println("Browser: Chrome");
		System.setProperty("webdriver.chrome.drive", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Before(order=1)
	public void scnarioDetails(Scenario scen) {
		
		System.out.println(
				"------------------------------Starting Scenario-----------------------------------------------");
		 System.out.println("Scnario Name: "+scen.getName());  ;
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		
	}
	
	@After(order = 2)
	public void tearUp() {
		driver.close();
		driver.quit();
		
	}
	
	@After(order=1)
	public void scnarioEndDetails(Scenario scen) {
		
		System.out.println(
				"------------------------------Ending Scenario-----------------------------------------------");
		 System.out.println("Scnario Name: "+scen.getName() + " Result: " + scen.getStatus() );
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		
	}
	
	@Given("^I want to launch (.*) page$")
	public void launchPageStep(String Url) {
		String pageUrl = PropertiesFileHandler.readURLProerties(Url);
		driver.get(pageUrl);
	}
	
	@And("I enter username")
	public void i_enter_username() {
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Shiv Mangal");
	}
	
	@And("I enter email")
	public void i_enter_email() {
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("Shiv@example.com");
	}
	
	@And("I enter password")
	public void i_enter_password() {
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("exe@123");
	}

	@When("I check on the checkbox")
	public void i_check_on_the_checkbox() {
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
	}

	@And("select gender as male")
	public void select_gender_as_male() {
		Select select = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		select.selectByVisibleText("Male");
	}

	@And("mark my employment status as Student")
	public void mark_my_employment_status_as_student() {
		driver.findElement(By.cssSelector("input[value='option1']")).click();
	}

	@Then("I Enter my date of birth as 12-Mar-1999")
	public void i_enter_my_date_of_birth_as_mar() {
		driver.findElement(By.cssSelector("input[type='date']")).sendKeys("14/03/1999");
	}

	@And("I click on submit button")
	public void i_click_on_submit_button() {
		driver.findElement(By.cssSelector("input[type='submit']")).click();
	}

}
