package Utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class alertUtils 
{
	protected WebDriver driver;
	
	public Alert SwitchtoAlert()
	{
		Alert alert = driver.switchTo().alert(); 
		return alert;
	}
	public void Dismiss()
	{
		SwitchtoAlert().dismiss();
	}
	
}
