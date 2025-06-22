package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProvider {

	@DataProvider(name="daata")
	public Object[][] getData() {

		Object[][] data = new Object[4][2];
			data[0][0] = "Shiv Mangal" ;
			data[0][1] = "smangal" ;
			
			data[1][0] = "Anil Kumar Gupta" ;
			data[1][1] = "akgupta" ;
			
			data[2][0] = "Kanika Bhardwaj" ;
			data[2][1] = "Kbhardwaj" ;
			
			data[3][0] = "Soumya Mishra" ;
			data[3][1] = "smishra" ;
			
		return data;
	}

	
	
	@Test(dataProvider = "daata", description="This is an example of DataProviders in TestNG")
	public void test1(String name , String userName) {
		System.out.println("Name: " + name);
		System.out.println("UserName: " + userName);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("--------------------------------------------------------------");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("--------------------------------------------------------------");
	}
}
