package com.project_expoert_BaseClass;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.project_export_ITestListner.TestNgListeners;

@Listeners(TestNgListeners.class)
public class Base_Class {
	static ExtentReports extent;
 protected static WebDriver driver=null;
	
	@BeforeMethod
	public void applicationSetup()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://pceuat.convstaging.com/aus");
		
		// Click on UK Site
		//driver.findElement(By.xpath("//a[2]")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,30);
	}
	
	@AfterMethod
	public void applicationClose()
	{
		driver.quit();
		
		
	}
	
	public static String failure(ITestResult result) {
		Date currentdate = new Date();

		String screenshotFilename = currentdate.toString().replace(" ", "-").replace(":", "-");

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destpath=System.getProperty("user.dir")+"\\FailedScreenshot\\" + screenshotFilename+result.getName()+ ".png";
		
		  try { 
			  FileUtils.copyFile(source, new File(".//FailedScreenshot//" + screenshotFilename+result.getName()+ ".png")); 
		  } catch (IOException e) { 
			  
		  //TODO Auto-generated catch block
		  e.printStackTrace();
		  }
		return screenshotFilename;
		 
	}
	
	public void passed(ITestResult result) {
		Date currentdate = new Date();

		String screenshotFilename = currentdate.toString().replace(" ", "-").replace(":", "-");

		File screensht = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screensht, new File(".//PassedScreenshot//" + screenshotFilename+result.getName()+ ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	  public static String getScreenshotPath(String TestCaseName, WebDriver driver) throws IOException {
		  TakesScreenshot ts=(TakesScreenshot)driver;
	  
	  File source=ts.getScreenshotAs(OutputType.FILE);
	  
	  String destPath=System.getProperty("user.dir")+"\\Reports1\\"+TestCaseName+".png";
	  File file=new File(destPath); 
	  FileUtils.copyFile(source, file); 
	  return destPath;
	  
	  }
	 
	
}
