package tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataProvider.TestDataProvider;
import driver.DriverFactory;
import pages.CartPage;
import pages.HomePage;
import utils.LoggerUtils;

public class CartTest extends BaseTest{
	
	private static final Logger log = LoggerUtils.getLogger(CartTest.class);
	
	private HomePage homePage;
    private CartPage cartPage;
	
	@Test(priority = 0,dataProvider = "searchData",
	          dataProviderClass = TestDataProvider.class)
	public void homePage(String field, String value) {
		log.info("Started Home Page Tests");
		homePage = new HomePage(DriverFactory.getDriver());

		log.info("Entering search text in search field");
	    homePage.enterSearchText(value);

	    //log.info("Clicking on search button");
	    //homePage.clickSearch();

	    log.info("Search action completed successfully");
	}
	
	@Test(priority = 1, dependsOnMethods = "homePage")
    public void addCart() {
	    log.info("Started Add to Cart Test");
	    cartPage =new CartPage(DriverFactory.getDriver());

	    log.info("Applying brand filter");
	    cartPage.clickBrandFilter();

	    log.info("Applying storage filter");
	    cartPage.clickStorageFilter();

	    log.info("Clicking Add to Cart button");
	    cartPage.clickAddToCart();

	    log.info("Navigating to Cart page");
	    cartPage.clickGoToCart();

	    int actualCount = cartPage.getCartCount();

	    log.info("Cart count fetched from UI: " + actualCount);
	    Assert.assertEquals(actualCount,1,"Cart count mismatch");

	    log.info("Cart count validation successful");
    }
	
	@Test(priority = 2, dependsOnMethods = "addCart")
	public void removeCart() {
		log.info("Started Remove To Cart Test");
	    cartPage =new CartPage(DriverFactory.getDriver());

	    log.info("Removing Product From Cart");
	    cartPage.removeProduct();;
		
	    int actualCount = cartPage.getCartCount();

	    log.info("Cart count fetched from UI: " + actualCount);
	    Assert.assertEquals(actualCount,0,"Cart count mismatch");

	    log.info("Cart count validation successful");
	}

}
