package cucumber.stepdefinations;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import cucumber.utils.BaseFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ActionsPracticeStepSefinations extends BaseFunctions{

	Actions action ;

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
