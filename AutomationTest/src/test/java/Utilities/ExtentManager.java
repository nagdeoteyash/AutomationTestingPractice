package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentManager 
{
	public void ExtentReport()
	{
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\ASUS\\git\\AutomationTestingPractice\\AutomationTest\\ExtentReport\\TestReport.html");
		extentReports.attachReporter(sparkReporter);
		extentReports.flush();
	}
	
}  
	