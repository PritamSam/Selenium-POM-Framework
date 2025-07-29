package Udemy_Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assertions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String name="rahul";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String password = getPassword(driver);
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signinBtn")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class=login-container] h2")).getText(),"Hello "+name+",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();

	}
	
	//Function to dynamically enter the password from the text
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);//intercepted error
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
		//password to split
		String[] passwordArray = passwordText.split("'");
		//0th index = Please use temporary password 
		//1st index = 'rahulshettyacademy' to Login.
		//0th index =  rahulshettyacademy
		//1st index =  to
		//2nd index =  Login.
		String password = passwordArray[1].split("'")[0];
		//driver.findElement(By.cssSelector(".go-to-login-btn"));
		return password;
		
		
	}

}
