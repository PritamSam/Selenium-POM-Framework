package utils;
//Step 5 : create Helper Class to handle Alert
import org.openqa.selenium.WebDriver;

public class browserUtils {
	 public static void switchToWindow(WebDriver driver, String title) {
	        for (String handle : driver.getWindowHandles()) {
	            driver.switchTo().window(handle);
	            if (driver.getTitle().contains(title)) {
	                break;
	            }
	        }
	 }

}
