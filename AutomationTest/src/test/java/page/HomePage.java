package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage 
{
	private WebDriver driver;
	//private will be only accessible with the class in which they are declared
	
	private By link = By.xpath("//h3/a[@href='/inputs']");
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void click_input()
	{
		driver.findElement(link).click();
	}
	
	

}
