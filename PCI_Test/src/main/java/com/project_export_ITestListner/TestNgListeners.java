package com.project_export_ITestListner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.project_ExtentReportListener.ExtentReportreNG;
import com.project_expoert_BaseClass.Base_Class;

public class TestNgListeners extends Base_Class implements ITestListener{

	ExtentReports extent=ExtentReportreNG.getReportDobject();
	ExtentTest test;
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	@Override  
	public void onTestStart(ITestResult result) {  
	test=extent.createTest(result.getMethod().getMethodName());
	extentTest.set(test);
	}  
	  
	@Override  
	public void onTestSuccess(ITestResult result) {  
	extentTest.get().log(Status.PASS, "Test Passes");
	System.out.println("Success of test cases and its details are : "+result.getName()); 
	passed(result);
	}  
	  
	@Override  
	public void onTestFailure(ITestResult result) {  
	
		/*WebDriver driver = null;
	extentTest.get().fail(result.getThrowable());
	
	Object testObject=result.getInstance();
	Class classe=result.getTestClass().getRealClass();
	try {
		driver= (WebDriver)classe.getDeclaredField("driver").get(testObject);
	}catch (Exception e1) {
		
	}*/
		extentTest.get().fail(result.getThrowable());
	try {
		String path=Base_Class.getScreenshotPath(result.getName(),driver);
		extentTest.get().addScreenCaptureFromPath(path);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	failure(result);
	}  
	  
	@Override  
	public void onTestSkipped(ITestResult result) {  
	// TODO Auto-generated method stub  
	//System.out.println("Skip of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	 
	//System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onStart(ITestContext context) {  
	// TODO Auto-generated method stub  
	}  
	  
	@Override  
	public void onFinish(ITestContext context) {  
	// TODO Auto-generated method stub  
		extent.flush();
	}  
}
