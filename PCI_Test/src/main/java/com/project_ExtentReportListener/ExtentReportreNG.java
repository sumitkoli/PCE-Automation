package com.project_ExtentReportListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportreNG {
	static ExtentReports extent;
	
	public static ExtentReports getReportDobject() {
		
		  String path=System.getProperty("user.dir")+"\\Reports\\index.html";
		  ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		  
		  reporter.config().setReportName("PCE Automation Result");
		  reporter.config().setDocumentTitle("Test Result");
		  
		  extent =new ExtentReports(); extent.attachReporter(reporter);
		  extent.setSystemInfo("Tester", "Sumit"); return extent;
		 
	}
}

