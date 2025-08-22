package base;

//Step 1 :  Create Base Class and its methods to open and close browser

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	protected WebDriver driver;
	
	//Step 1.1 -  Invoking browser and get the URL
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
	}
	
	//Step 1.2 - After completing test, close the browser
	@AfterMethod
	public void teardown()
	{
		if (driver!=null)
			driver.quit();
	}

}
