package tests;

import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataProvider.TestDataProvider;
import driver.DriverFactory;
import models.Product;
import pages.HomePage;
import pages.SortPage;
import utils.LoggerUtils;

public class SortProductTest extends BaseTest{

	private static final Logger log = LoggerUtils.getLogger(SortProductTest.class);
	
	private SortPage sortPage;
	private HomePage homePage;
	
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
	public void sortProducts() {

        log.info("Starting Sort Products Test");

        sortPage =
                new SortPage(DriverFactory.getDriver());

        log.info("Fetching all products from UI");

        List<Product> products =
                sortPage.getAllProducts();

        log.info("Total products fetched: " + products.size());
        
        Assert.assertTrue(products.size() > 0, "No products found - check locators or page load");

	    // sort low to high
	    products.sort(Comparator.comparing(Product::getPrice));
	    
	    log.info("Sorting completed successfully");

	    Product lowest = products.get(0);
	    Product highest = products.get(products.size() - 1);

	    System.out.println("Lowest Price Product:");
	    System.out.println("Lowest Product Detail - "+lowest.getName());
	    System.out.println("Lowest Product Price - "+lowest.getPrice());

	    System.out.println("Highest Price Product:");
	    System.out.println("Highest Product Detail - "+highest.getPrice());
	    System.out.println("Highest Prodcut Price - "+highest.getPrice());
	}
}
