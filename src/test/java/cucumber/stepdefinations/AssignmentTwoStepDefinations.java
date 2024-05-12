package cucumber.stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import cucumber.utils.BaseFunctions;
import cucumber.utils.PropertiesFileHandler;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssignmentTwoStepDefinations extends BaseFunctions {

	@Given("^I want to launch (.*) page$")
	public void launchPageStep(String Url) {
		String pageUrl = PropertiesFileHandler.readURLProerties(Url);
		launchApplication(pageUrl);
	}

	@And("I enter username")
	public void i_enter_username() {
		element(By.cssSelector("input[name='name']")).sendKeys("Shiv Mangal");
	}

	@And("I enter email")
	public void i_enter_email() {
		element(By.cssSelector("input[name='email']")).sendKeys("Shiv@example.com");
	}

	@And("I enter password")
	public void i_enter_password() {
		element(By.cssSelector("input[type='password']")).sendKeys("exe@123");
	}

	@When("I check on the checkbox")
	public void i_check_on_the_checkbox() {
		element(By.cssSelector("input[type='checkbox']")).click();
	}

	@And("select gender as male")
	public void select_gender_as_male() {
		Select select = new Select(element(By.id("exampleFormControlSelect1")));
		select.selectByVisibleText("Male");
	}

	@And("mark my employment status as Student")
	public void mark_my_employment_status_as_student() {
		element(By.cssSelector("input[value='option1']")).click();
	}

	@Then("I Enter my date of birth as 12-Mar-1999")
	public void i_enter_my_date_of_birth_as_mar() {
		element(By.cssSelector("input[type='date']")).sendKeys("14/03/1999");
	}

//	@And("I click on submit button")
//	public void i_click_on_submit_button() {
//		element(By.cssSelector("input[type='submit']")).click();
//	}

	@Given("^I want to enter (.*) in (.*)$")
	public void i_want_to_enter_rahulshettyacademy_in_login_page_user_name(String userName, String locator) {
		element(locator).sendKeys(userName);
	}

	@When("^I click on (.*) radioButton$")
	public void i_click_on_login_page_user_radio_button(String locator) {
		element(locator).click();

	}

	@When("^accept the (.*)$")
	public void accept_the_pop_up_msg(String locator) {
		element(locator).click();
	}

	@When("^I select (.*) using visibleText (.*)$")
	public void i_select_login_page_selector_using_visible_text_consultant(String locator, String visibleText) {
		Select options = new Select(element(locator));
		options.selectByVisibleText(visibleText);
	}

	@Then("^I verify (.*) value is (.*)$")
	public void i_verify_login_page_selector_value_is_consultant(String locator, String expectedText) {
		Select options = new Select(element(locator));
		String actualText = options.getFirstSelectedOption().getText();
		Assert.assertTrue(actualText.equalsIgnoreCase(expectedText),
				"Actual text:" + actualText + "is not equals to Expected Text: " + expectedText);
		logMessage("[ASSERT PASS]: Actual text:" + actualText + "is equals to Expected Text: " + expectedText);
	}

	@Then("^I click on (.*) checkbox$")
	public void i_click_on_login_page_terms_checkbox(String locator) {
		element(locator).click();
	}

	@Then("^I click on (.*) button$")
	public void i_click_on_login_page_sign_in_button(String locator) {
		element(locator).click();
	}

}
