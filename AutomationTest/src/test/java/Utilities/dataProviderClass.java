package Utilities;

import org.testng.annotations.DataProvider;

public class dataProviderClass 
{
	
	@DataProvider(name = "loginInfo")
	public Object[][] dataset()
	{
		return new Object[][]
				{
					{"1" , "Yash" ,  "yash@123" , "21052000"},
					{"2" , "megha" ,  "megha@123" , "10022002"},
					{"3" , "prasad" ,  "prasad@123" , "11122008"}
				};
	}

}
