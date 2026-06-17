package base;

import java.io.File;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import driver.BrowserManager;
import driver.DriverFactory;
import utils.ConfigReader;
import utils.LoggerUtils;
import utils.ScreenshotUtils;

//BaseTest initializes the driver before each test and closes it afterward.

public class BaseTest {
	
	private static final Logger log = LoggerUtils.getLogger(BaseTest.class);
	
	@BeforeSuite
	public void createLogsFolder() {

	    File logsDir = new File("logs");

	    if (!logsDir.exists()) {
	        logsDir.mkdirs();
	    }
	    
	    File reportsDir = new File("reports");
	    
	    if (!reportsDir.exists())
	    {
	    	reportsDir.mkdirs();
	    }
	    
	    File screenshotsDir = new File("screenshots");
	    
	    if(!screenshotsDir.exists())
	    {
	    	screenshotsDir.mkdirs();
	    }
	}

	@BeforeClass
    public void setUp() {
		
		String url = ConfigReader.getProperty("baseUrl");
		long waitTime = Long.parseLong(ConfigReader.getProperty("implicitWait"));
		
        String browser = System.getProperty("browser", "chrome");

        log.info("========================================");
	    log.info("Test execution started");
	    log.info("Browser selected: " + browser);
	    
        BrowserManager browserManager = new BrowserManager();

        WebDriver driver =
                browserManager.createDriver(browser);

        DriverFactory.setDriver(driver);
        log.info("WebDriver initialized successfully");
     
        DriverFactory.getDriver().manage().window().maximize();
        log.info("Browser window maximized");
        
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
        log.info("Implicit wait set to {} seconds", waitTime);
        
        log.info("Navigating to URL");
        DriverFactory.getDriver().get(url);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        try {

            if (DriverFactory.getDriver() != null) {

                ScreenshotUtils.captureScreenshot(
                        DriverFactory.getDriver(),
                        result.getName()
                );
            }

        } catch (Exception e) {
            log.error("Failed to capture screenshot", e);
        }

    }
    
    @AfterClass
    public void tearDownClass() {

        try {
            if (DriverFactory.getDriver() != null) {
                DriverFactory.quitDriver();
            }
        } catch (Exception e) {
            log.error("Error closing browser", e);
        }

        log.info("Test execution finished. Closing browser");

        DriverFactory.quitDriver();

        log.info("========================================");
;
    }
}