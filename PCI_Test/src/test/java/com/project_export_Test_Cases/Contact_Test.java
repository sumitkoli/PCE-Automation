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
import com.project_export_Driver_Action.Action_Driver;
import com.project_export_Page_Object.Contact_Page;
import com.project_export_Page_Object.Home_Page;

public class Contact_Test extends Base_Class {

	Action_Driver action_driver;

	@Test
	public void Test0019_contact_withvalidDetails() throws InterruptedException {

		Thread.sleep(3000);

		Home_Page home_page = new Home_Page();

		home_page.clickonContactTab();

		Contact_Page contact_page = new Contact_Page();

		driver.findElement(By.xpath("//a[@class='cc-btn cc-dismiss']")).click();

		// Scroll down
		action_driver = new Action_Driver();
		action_driver.javascript_Executor("window.scrollBy(0,500)");

		WebElement frameID = driver.findElement(By.xpath(
				"//body/div[@id='wrapper']/div[@id='wrapperinner']/div[@id='area']/div[@id='areainner']/div[@id='contentarea']/div[1]/div[1]/div[1]/div[3]/div[1]/iframe[1]"));

		driver.switchTo().frame(frameID);

		contact_page.enteremailId("abc@gmail.com");

		contact_page.entername("Test");

		contact_page.entersubject("Test");

		contact_page.entermessage("Test");

		contact_page.clickonsubmitbtn();

		Thread.sleep(2000);

		String expected = driver.findElement(By.xpath("//div[@class='alert-message']")).getText();

		System.out.println(expected);

		String actual = "     Data Saved Successfully.";

		Assert.assertEquals(actual, expected);

	}

	@Test
	public void Test0020_contact_with_InvalidDetails() throws InterruptedException {

		Thread.sleep(3000);

		Home_Page home_page = new Home_Page();

		home_page.clickonContactTab();

		Contact_Page contact_page = new Contact_Page();

		driver.findElement(By.xpath("//a[@class='cc-btn cc-dismiss']")).click();

		// Scroll down
		action_driver = new Action_Driver();
		action_driver.javascript_Executor("window.scrollBy(0,500)");

		WebElement frameID = driver.findElement(By.xpath(
				"//body/div[@id='wrapper']/div[@id='wrapperinner']/div[@id='area']/div[@id='areainner']/div[@id='contentarea']/div[1]/div[1]/div[1]/div[3]/div[1]/iframe[1]"));

		driver.switchTo().frame(frameID);

		String subjectid = driver.findElement(By.id("subject")).getAttribute("class");

		System.out.println(subjectid);

		contact_page.enteremailId("abc@gmail.com");

		contact_page.entername("Test");

		// contact_page.entersubject("Test");

		contact_page.entermessage("Test");

		contact_page.clickonsubmitbtn();

		Thread.sleep(2000);
		
		String subjectid1 = driver.findElement(By.id("subject")).getAttribute("class");

		System.out.println(subjectid1);

		if (subjectid1.contains("error")) {
			System.out.println("Its enabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}
}
