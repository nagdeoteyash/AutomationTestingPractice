package tests;

import org.testng.annotations.Listeners;
//import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import page.HomePage;
import page.WebInputPage;
import Utilities.dataProviderClass;
@Listeners(Utilities.ListenersUtils.class)
//if we want to use listeners directly without any XML file Use.





public class ATPW_Test01 extends BaseTest
{
	@Test(priority = 1 )
	public void Homepage()
	{
		HomePage Hp1 = new HomePage(driver);
		Hp1.click_input();
	}
	@Test(priority = 2 , 
			dataProvider = "loginInfo", dataProviderClass = dataProviderClass.class)
	public void WebInputTest02(String number , String Text , String Password , String Date)
	{
		
		WebInputPage Wip1= new WebInputPage(driver);
		 Wip1.NumberInput(number);
		 Wip1.TextInput(Text);
		 Wip1.PassWordInput(Password);
		 Wip1.DateInput(Date);
		 Wip1.ClickDisplayButton();
		 Wip1.ClickClearBtn();
	}
}
