package cucumber.runners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import cucumber.utils.BaseFunctions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		glue = "cucumber.stepdefinations",
		features = "src/test/resources/Features/",
		tags = "@Actions",
		plugin = {"html:target/cucumber/html.html"},
		monochrome = false
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	BaseFunctions obj = new BaseFunctions();
	
	@BeforeClass
	public void beforeAll() {
		obj.initializeBrowser();
	}
	
	@AfterClass
	public void afterAll() {
		obj.endSession();
	}
	
}
