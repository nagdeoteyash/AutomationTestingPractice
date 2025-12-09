package tests;

import org.testng.annotations.Test;

import Utilities.dataProviderClass;
import base.BaseTest;
import page.HomePage;
import page.LoginPage;

public class ATPW_Test02  extends BaseTest
{
	@Test(priority = 1)
	public void Homepage()
	{
		HomePage Hp1 = new HomePage(driver);
		Hp1.Click_TestLoginPage();
	}
	
	@Test(priority = 2 ,
			dataProvider = "Passcode", dataProviderClass = dataProviderClass.class )
	public void LoginTest03(String username,String Passcode)
	{
		HomePage Hp1 = new HomePage(driver);
		Hp1.Click_TestLoginPage();
		LoginPage LT = new LoginPage();
		LT.Username_input(username);
		LT.passWord_input(Passcode);
	}

}
