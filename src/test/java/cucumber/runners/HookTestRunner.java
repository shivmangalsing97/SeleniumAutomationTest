package cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		glue = "cucumber.hooksteps",
		features = "src/test/resources/Features/HooksPractice.feature",
		tags = "@Hook",
		plugin = {"html:target/cucumber/html.html"}
)
public class HookTestRunner extends AbstractTestNGCucumberTests {

	
}
