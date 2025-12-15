package Utilities;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtil implements ITestListener
{
	public ExtentSparkReporter sparkReporter; //UI of the report 
	public ExtentReports extent ; //populate common info on the reports
	public ExtentTest test ; //Creating test case entries in the report and update status of the test methods
	
	
	public void onStart(ITestContext context)
	{																
		String path = System.getProperty("user.dir") + "\\ExtentReport\\report.html";
		sparkReporter = new ExtentSparkReporter(path);
		sparkReporter.config().setDocumentTitle("Automation Report");  //Title of report
		sparkReporter.config().setReportName("Functional testing"); //Name of report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();  //object 
		extent.attachReporter(sparkReporter); //combining ExtentSparkReporter UI with ExtentReports
		
		//common info 
		extent.setSystemInfo("computer Name", "local host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Yash");
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Browser Name", "Chrome");
	
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());  //create a new entry in the report
		test.log(Status.PASS,"Test Case Passed is" +result.getName()); //update ststus
	}
	
	public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test Failed: " + result.getName());
        test.log(Status.FAIL, result.getThrowable());

        // get WebDriver from base test
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");

        if (driver != null) {
            String screenshotPath = captureScreenshot(driver, result.getName());

            try {
                test.addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case Skipped is "+ result.getName());
	}
	
	public void onFinish (ITestContext context)
	{
		extent.flush();
	}
	
	
	
	public String captureScreenshot(WebDriver driver, String testName) {

	    String screenshotPath = System.getProperty("user.dir")
	            + "\\ExtentReport\\Screenshots\\" + testName + ".png";

	    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    File dest = new File(screenshotPath);

	    try {
	        dest.getParentFile().mkdirs();  // create folder if not exists

	        java.nio.file.Files.copy(
	                src.toPath(),
	                dest.toPath(),
	                java.nio.file.StandardCopyOption.REPLACE_EXISTING
	        );

	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return screenshotPath;
	}

	
}
