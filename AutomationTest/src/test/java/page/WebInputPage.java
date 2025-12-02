package page;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.WaitUtils;

public class WebInputPage 
{
	private WebDriver driver;
	
	//constructor
	public WebInputPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	//all the locators
	private By InputNumber= By.id("input-number");
	private By InputText = By.xpath("//input[@id='input-text']");
	private By InputPassword = By.xpath("//input[@id='input-password']");
	private By InputDate = By.xpath("//input[@id='input-date']");
	private By Btn_DisplayInput = By.xpath("//button[@id='btn-display-inputs']");
	
	//locators for Assert 
	private By assert_Number = By.xpath("//strong[@id='output-number']");
	//private By assert_text = By.xpath("//strong[@id='output-text']");
	//private By assert_password = By.xpath("//strong[@id='output-password']");
	//private By assert_date = By.xpath("//strong[@id='output-date']");
	
	
	//all functions which will perform actions.
	public String NumberInput(String a)
	{
		WaitUtils.waitForClickable(driver, InputNumber).sendKeys(a);
		String NumberText=WaitUtils.waitForClickable(driver, InputNumber).getText();
		return NumberText;
	}
	
	public void TextInput(String b)
	{
		WaitUtils.waitForClickable(driver, InputText).sendKeys("Yash Nagdeote");
		
	}
	public void PassWordInput(String c)
	{
		WaitUtils.waitForClickable(driver,InputPassword ).sendKeys("YashNagdeote@2000");
	}
	public void DateInput(String d)
	{
		WaitUtils.waitForClickable(driver,InputDate ).sendKeys("21052000");
	}
	public void ClickDisplayButton()
	{
		WaitUtils.waitForClickable(driver,Btn_DisplayInput ).click();
	}
	public String AssertNumber()
	{
		String AssertNumberActual = WaitUtils.waitForVisibility(driver, assert_Number).getText();
		System.out.println("Text inside strong tag: " + AssertNumberActual);
		return AssertNumberActual;
	}

	
}
