package com.project_expoert_BaseClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.project_export_ITestListner.TestNgListeners;

@Listeners(TestNgListeners.class)
public class Base_Class {

protected static WebDriver driver;
	
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
	
	public void failure(ITestResult result) {
		Date currentdate = new Date();

		String screenshotFilename = currentdate.toString().replace(" ", "-").replace(":", "-");

		File screensht = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screensht, new File(".//FailedScreenshot//" + screenshotFilename+result.getName()+ ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
}
