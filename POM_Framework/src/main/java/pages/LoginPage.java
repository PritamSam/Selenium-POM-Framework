package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Step 2 : To add methods for the locators
public class LoginPage {
	
	private WebDriver driver;
	
	private By usernameTextBox = By.id("Email");
	private By passwordTextBox = By.id("Password");
	private By loginButton = By.cssSelector(".button-1.login-button");
	
	//Creating Constructor of this class
	//If we have to pass an argument to this class , we can do it with help of constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	public void enterUsername(String username)
	{
		driver.findElement(usernameTextBox).clear();
		driver.findElement(usernameTextBox).sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys(password);
	}
	
	public void clickLogin()
	{
		driver.findElement(loginButton).click();
	}

}
