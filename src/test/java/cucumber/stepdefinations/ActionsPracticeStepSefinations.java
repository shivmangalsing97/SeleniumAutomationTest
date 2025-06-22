package cucumber.stepdefinations;


import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;

import cucumber.utils.BaseFunctions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ActionsPracticeStepSefinations extends BaseFunctions{

	Actions action ;
//	ExtentReports extent ;
	
	@Before(order=0)
	public void scnarioDetails(Scenario scen) {
		
		System.out.println(
				"------------------------------Starting Scenario-----------------------------------------------");
		 System.out.println("Scnario Name: "+scen.getName());  ;
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		
	}
	
//	@Before(order=1)
//	public void startReporting(Scenario scen) {
//		extent = new ExtentReports();
//		extent.attachReporter(report);		
//	}
	
	
	@After(order=0)
	public void failScenarioTakingScreenshot(Scenario scenario)
	{
		if(scenario.isFailed()) {
			scenario.attach(takeScreenShot().getScreenshotAs(OutputType.BYTES), 
					"image/png", "Scenario Failed Taking Screenshot");
		}
	}
	
	@After(order=1)
	public void scnarioEndDetails(Scenario scen) {
		
		System.out.println(
				"------------------------------Ending Scenario-----------------------------------------------");
		 System.out.println("Scnario Name: "+scen.getName() + " Result: " + scen.getStatus() );
		System.out.println(
				"---------------------------------------------------------------------------------------------");
		
	}

	@When("^I move to the (.*) element$")
	public void mouseOverToElement(String element) {
		
		action = moveToElement(element(element)) ;
	}
	
	@And("^press shift key and type (.*)$")
	public void pressShiftKeyAndSendKeys(String text) {
		action = action.click().keyDown(Keys.SHIFT).sendKeys(text);
	}

	@And("^double click and select it$")
	public void doubleCLickOnElement() {
		action = action.doubleClick() ;
	}
	
	@And("^I build and perform actions$")
	public void buildAndPerformAction() {
		action.build().perform();
	}

}
