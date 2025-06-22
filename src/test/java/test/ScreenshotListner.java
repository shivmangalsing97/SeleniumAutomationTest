package test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListner implements ITestListener {
	
	public static WebDriver driver ;

	public void onTestFailure(ITestResult result) {
		
		String timeStamp = new SimpleDateFormat("hhmmss").format(new Date());
		String methodName = result.getMethod().getMethodName() ;
		TakesScreenshot screeshot = (TakesScreenshot) driver ;
		File source = screeshot.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(source, new File("src/test/resources/SeleniumScreenshots/"+methodName+timeStamp+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
