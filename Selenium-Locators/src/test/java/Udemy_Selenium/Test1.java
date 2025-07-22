package Udemy_Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 *  src/main/test folder is used for Selenium Automation Test Framework. It is place to write Test Code 
 * 
 * */

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Invoking a browser
		//Chrome - ChromeDriver -> Methods
		 
		// Interface is a method with empty body. Here WebDriver is an interface
		// ChromeDriver is a class which consists of body implements interface
		
		//WebDriver driver =  new ChromeDriver() helps to access methods of webdriver interface and helps to switch browser easliy
		//ChromeDriver driver =  new ChromeDriver() helps to access methods of ChromeDriver class where polymorphism is not allowed and hence switching browser is not possible
		// Chromedriver.exe = It is the file responsible to invoke chrome driver
		//Selenium Manager - It helps to download the chromedriver.exe and set the path automatically which will invoke browser to perform some action
		
		WebDriver driver =  new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver","path");
		//WebDriver driver =  new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		WebElement chrome = driver.findElement(By.name("q"));
		chrome.sendKeys("eat");
		chrome.submit();
		Thread.sleep(1000);
		driver.close();
		

	}

}
