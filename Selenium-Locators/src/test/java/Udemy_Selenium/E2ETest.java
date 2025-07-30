package Udemy_Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class E2ETest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
	/*	driver.get("https://www.google.com/");
		WebElement e = driver.findElement(By.name("gLFyf"));
		e.sendKeys("Pritam");
		e.sendKeys(Keys.ENTER);
	*/
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//static dropdown
		WebElement e = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select s = new Select(e);
		s.selectByContainsVisibleText("INR");
		System.out.println(s.getFirstSelectedOption().getText());
		s.selectByIndex(2);
		System.out.println(s.getFirstSelectedOption().getText());
		s.selectByValue("USD");
		System.out.println(s.getFirstSelectedOption().getText());
		
		//Static drop down with click
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		System.out.println("Count Before clicking");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		for(int i=1;i<=2;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		int i=1;
		while(i<=2)
		{
			driver.findElement(By.id("hrefIncInf")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println("Count After clicking");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		//Dynamic Drop Down
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='IXB']")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction")).click();
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		
		//AutoSuggest
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(1000);
		List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		for(WebElement option :options)
		{
		if(option.getText().equalsIgnoreCase("India"))
		{
		option.click();
		break;
		}
		}
		
		//Checkbox
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//count number of checkboxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		//calendar
		driver.findElement(By.cssSelector(".ui-datepicker-trigger")).click();
		driver.findElement(By.xpath("//td[@data-month='5']/a[contains(text(),'13')]")).click();
		
		driver.close();

	}
}
