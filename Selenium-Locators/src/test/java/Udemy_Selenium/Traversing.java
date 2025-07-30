package Udemy_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Traversing {

	public static void main(String[] args) {
		
		/* X-Path Axes
		 
		| Axis                   | Description                      |
		| ---------------------- | -------------------------------- |
		| `child::`              | Selects child nodes              |
		| `parent::`             | Selects parent node              |
		| `ancestor::`           | Selects all ancestors            |
		| `ancestor-or-self::`   | Ancestors + current node         |
		| `descendant::`         | All descendants                  |
		| `descendant-or-self::` | Descendants + current node       |
		| `following::`          | All nodes after the current one  |
		| `preceding::`          | All nodes before the current one |
		| `following-sibling::`  | Siblings after current node      |
		| `preceding-sibling::`  | Siblings before current node     |
		| `self::`               | The current node                 |
 
		 */
		
		/* X-Path Methods to find dynamic element
		 * 
		 * contains() - Matches part of string. Ex - //input[contains(@id, 'user')] 
		 * starts-with() - Matches beginning of string. Ex - //button[starts-with(@id, 'btn')]
		 * ends-with() - Matches ending of string. Ex - //button[ends-with(@id, 'btn')]
		 * text() - For partial matches. Ex - //div[contains(text(), 'Welcome')]
		 * wildcards - Matches elements regardless of tagname. Ex - //*[@id='login']
		 * 
		 */
		
		WebDriver driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Sibling-Child to parent traverse using xpath
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		//Child-Parent Traverse using xpath
		System.out.println(driver.findElement(By.xpath("//header/div/button[2]/parent::div/parent::header/a[2]")).getText());;
		//Traversing Parent-Grandchild using css Selector
		System.out.println(driver.findElement(By.cssSelector("header > div >button[class='btn btn-primary']:nth-child(3)")).getText());
		//Traversing Parent-Immediatechild using css Selector
		System.out.println(driver.findElement(By.cssSelector("header a:nth-child(2)")).getText());
		driver.close();

	}

}
