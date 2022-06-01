package com.project_export_Test_Cases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project_expoert_BaseClass.Base_Class;
import com.project_export_Page_Object.Awards_Form_Page;
import com.project_export_Page_Object.Categories_and_Criteria_Page;
import com.project_export_Page_Object.Home_Page;

public class Awards_Form extends Base_Class {
	Home_Page home_page;

	Categories_and_Criteria_Page categories_page;

	Awards_Form_Page awards_page;

	@Test
	public void Test0017_Awards_Form_with_ValidDetails() throws InterruptedException {
		home_page = new Home_Page();

		home_page.movetoAwardsTab();

		home_page.clickonCategoriesCriteria();

		categories_page = new Categories_and_Criteria_Page();

		Thread.sleep(2000);

		categories_page.clickonNewappBtn();

		Set<String> Windows = driver.getWindowHandles();

		Iterator<String> it = Windows.iterator();

		String parentId = it.next();
		String childId = it.next();

		driver.switchTo().window(childId);

		awards_page = new Awards_Form_Page();

		awards_page.enterFirstName("Jack");

		awards_page.enterLastName("Jones");

		awards_page.enterJobtittle("BA");

		awards_page.enterCompanyName("CDAC");

		awards_page.enterpostalAddress1("Bay Street");

		awards_page.enterpostalAddress2("Behind high School");

		awards_page.enterCity("Mumbai");

		awards_page.enterPostCode("40071");

		awards_page.selectCountry(2);

		awards_page.entertelephoneNo("33445522334");

		awards_page.enteremail("jack@gmail.com");

		awards_page.entercompanytwittername("cdactwitterdummy");

		awards_page.enterprojectName("Test1");

		awards_page.clickonprojectendDate();

		awards_page.selectProjectDate();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,300)");

		awards_page.acceptTermsandConditions();

		awards_page.clickSubmitbtn();

		String expected = driver.findElement(By.xpath("//h3[@class=' toppad pageheading']")).getText();

		String actual = "Thank you for submitting your application ";

		Assert.assertEquals(actual, expected);

	}

	@Test
	public void Test0018_Awards_Form_with_InvalidDetails() throws InterruptedException {
		home_page = new Home_Page();

		home_page.movetoAwardsTab();

		home_page.clickonCategoriesCriteria();

		categories_page = new Categories_and_Criteria_Page();

		Thread.sleep(2000);

		categories_page.clickonNewappBtn();

		Set<String> Windows = driver.getWindowHandles();

		Iterator<String> it = Windows.iterator();

		String parentId = it.next();
		String childId = it.next();

		driver.switchTo().window(childId);

		awards_page = new Awards_Form_Page();

		awards_page.enterFirstName("Jack");

		awards_page.enterLastName("Jones");

		awards_page.enterJobtittle("BA");

		awards_page.enterCompanyName("CDAC");

		awards_page.enterpostalAddress1("Bay Street");

		awards_page.enterpostalAddress2("Behind high School");

		awards_page.enterCity("Mumbai");

		awards_page.enterPostCode("40071");

		awards_page.selectCountry(2);

		// awards_page.entertelephoneNo("33445522334");

		awards_page.enteremail("jack@gmail.com");

		awards_page.entercompanytwittername("cdactwitterdummy");

		awards_page.enterprojectName("Test1");

		awards_page.clickonprojectendDate();

		awards_page.selectProjectDate();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,300)");

		awards_page.acceptTermsandConditions();

		awards_page.clickSubmitbtn();

		String actual = driver.switchTo().alert().getText();

		System.out.println(actual);
		
		String expected="All fields are required.";
		
		Assert.assertEquals(actual, expected);
		
		driver.switchTo().alert().accept();

	}

}
