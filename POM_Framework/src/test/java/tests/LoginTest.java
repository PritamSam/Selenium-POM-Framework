package tests;

import org.testng.annotations.Test;

// Step 3 - Perform actions by calling login Pag
import base.BaseTest;
import junit.framework.Assert;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void testLogin() {
		
		LoginPage  login = new LoginPage(driver);
		login.enterUsername("admin@yourstore.com");
		login.enterPassword("admin");
		login.clickLogin();
		
		
		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		Assert.assertEquals(driver.getCurrentUrl(), "https://admin-demo.nopcommerce.com/admin/");
	}

}
