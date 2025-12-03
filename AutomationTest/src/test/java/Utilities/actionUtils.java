package Utilities;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class actionUtils 
{
	RemoteWebDriver driver ; 
	public void actionObjectCreation()
	{
		 Actions actions = new Actions(driver);
		 actions.click().build().perform();
	}
	
	
}
