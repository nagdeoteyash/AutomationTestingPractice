package tests;






//import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import page.HomePage;
import page.WebInputPage;


public class ATPW_Test01 extends BaseTest
{
	@Test
	public void HomePagetest01()
	{
		HomePage Hp1 = new HomePage(driver);
		Hp1.click_input();
		//System.out.print(driver.getTitle());
		
		WebInputPage Wip1= new WebInputPage(driver);
		 Wip1.NumberInput("1");
		 Wip1.TextInput("yash Nagdeote");
		 Wip1.PassWordInput("yashnagdeote2000");
		 Wip1.DateInput("21052000");
		 Wip1.ClickDisplayButton();
		 //Assert.assertEquals(ExpNumber, Wip1.AssertNumber());
																																																																																																																																																																																																
	}
																																																		
}
