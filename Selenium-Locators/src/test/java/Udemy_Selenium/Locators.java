package Udemy_Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		//hard wait - Thread.sleep(1000)
		//Implicit wait
		//cssSelector  - tagname.class / tagname#id / tagname[Attribute='attributevalue]:nth-child(indexvalue)
		//xpath - //tagname[@Attribute='attribute value'] or //tagname[@Attribute='attribute value'][indexvalue]
		/*Traversing from top to bottom
		 * using cssSelector - .Parentclassname > .childclassname > .child-childclassname
		 * using xpath - //Parenttagname//childtagname[indexvalue]
		 * */
		
		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		driver.findElement(By.id("inputUsername")).clear();
		driver.findElement(By.name("inputPassword")).clear();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);//intercepted error
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		//indexing or chaining
		//By.xpath
		driver.findElement(By.xpath("//input[@type='text'][1]")).sendKeys("john");
		//By.cssSelector
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@rsa.com");
		//Traversing
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9234567654");
		//normal code
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		driver.findElement(By.cssSelector(".logout-btn")).click();
		driver.quit();
		

	}

}
