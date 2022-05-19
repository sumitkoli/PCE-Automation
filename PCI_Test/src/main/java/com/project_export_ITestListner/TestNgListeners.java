package com.project_export_ITestListner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.project_expoert_BaseClass.Base_Class;

public class TestNgListeners extends Base_Class implements ITestListener{

	@Override  
	public void onTestStart(ITestResult result) {  
	
	}  
	  
	@Override  
	public void onTestSuccess(ITestResult result) {  
	
	System.out.println("Success of test cases and its details are : "+result.getName()); 
	passed(result);
	}  
	  
	@Override  
	public void onTestFailure(ITestResult result) {  
	
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
	}  
}
