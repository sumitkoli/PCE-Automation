package com.project_export_Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project_expoert_BaseClass.Base_Class;
import com.project_export_Page_Object.Contact_Page;
import com.project_export_Page_Object.Home_Page;

public class Contact_Test extends Base_Class {

	//@Test
	public void Test0019_contact_withvalidDetails() throws InterruptedException {

		Thread.sleep(3000);

		Home_Page home_page = new Home_Page();

		home_page.clickonContactTab();

		Contact_Page contact_page = new Contact_Page();

		driver.findElement(By.xpath("//a[@class='cc-btn cc-dismiss']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		WebElement frameID = driver.findElement(By.xpath(
				"//body/div[@id='wrapper']/div[@id='wrapperinner']/div[@id='area']/div[@id='areainner']/div[@id='contentarea']/div[1]/div[1]/div[1]/div[3]/div[1]/iframe[1]"));

		driver.switchTo().frame(frameID);

		contact_page.enteremailId("abc@gmail.com");

		contact_page.entername("Test");

		contact_page.entersubject("Test");

		contact_page.entermessage("Test");

		contact_page.clickonsubmitbtn();

		Thread.sleep(2000);
		String expected = driver.findElement(By.xpath("//body/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]"))
				.getText();

		System.out.println(expected);

		String actual = "     Data Saved Successfully.";

		Assert.assertEquals(actual, expected);

	}
	
}
