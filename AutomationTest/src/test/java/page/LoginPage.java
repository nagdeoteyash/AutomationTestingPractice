package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	private WebDriver driver;
	
	private By Username = By.xpath("//input[@id='username']");
	private By Password =By.xpath("//input[@id='password']");
	
	
	
	public void Username_input(String InputTxtUsername)
	{
		driver.findElement(Username).sendKeys(InputTxtUsername);
	}
	public void passWord_input(String InputTxtpasscode)
	{
		driver.findElement(Password).sendKeys(InputTxtpasscode);;
	}
	public void QuitWin()
	{
		driver.quit();
	}

}