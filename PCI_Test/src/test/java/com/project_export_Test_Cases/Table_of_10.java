package com.project_export_Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.project_expoert_BaseClass.Base_Class;
import com.project_export_Page_Object.Home_Page;
import com.project_export_Page_Object.Purchase_Page;
import com.project_export_Page_Object.Registration_Page;
import com.project_export_Page_Object.Ticket_Register_Page;

public class Table_of_10 extends Base_Class {

	Home_Page home_page;
	Ticket_Register_Page ticket_page;
	Registration_Page registration_page;
	Purchase_Page purchase_page;

	@Test
	public void Test007_As_BookerwithSubmitand_ValidDetails() throws InterruptedException {
		home_page = new Home_Page();

		home_page.clickonregisterTab();

		ticket_page = new Ticket_Register_Page();

		Thread.sleep(2000);

		// click on Table of 10 Buy Option
		ticket_page.clickonBuyoptionTableofTen();

		// Click on yes radio button
		ticket_page.clickOnYesradiobtn();

		// Enter Username
		ticket_page.enteremail("sumit.koli1@conv.in");

		// Enter Password
		ticket_page.enterPassword("12345");

		// Click on Submit Button
		ticket_page.clickSubmit();

		registration_page = new Registration_Page();

		// Enter Table Name
		registration_page.enterTablename("Test Table");

		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.id("first_name_" + i)).sendKeys("Jack" + i);
			driver.findElement(By.id("last_name_" + i)).sendKeys("Jones" + i);
			driver.findElement(By.id("email_" + i)).sendKeys("jack" + i + "@gmail.com");
			driver.findElement(By.id("job_title_" + i)).sendKeys("BA" + i);
			driver.findElement(By.id("phone_" + i)).sendKeys("234567823" + i);
			driver.findElement(By.id("company_" + i)).sendKeys("CDADD" + i);

			WebElement registrationCategory = driver.findElement(By.id("registration_category_" + i));

			Select dropdown1 = new Select(registrationCategory);

			dropdown1.selectByIndex(1);

			WebElement dietaryreq = driver.findElement(By.id("dietary_requirements_" + i));

			Select dropdown2 = new Select(dietaryreq);

			dropdown2.selectByIndex(1);
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		registration_page.clickOntermsandCondt();

		registration_page.clickOnSubmitbtn();

		driver.switchTo().alert().accept();

		purchase_page = new Purchase_Page();

		js.executeScript("window.scrollBy(0,2000)");

		String actual = driver.findElement(By.xpath("//p[@class='thanksp']")).getText();

		System.out.println(actual);

		String expected = "Please review your registration information for event Project Control Expo 2022.\n"
				+ "If they are correct, please proceed with the payment.";

		Assert.assertEquals(actual, expected);

		Thread.sleep(2000);
		purchase_page.clickonSubmitbtn();

		/*
		 * WebElement frame1=driver.findElement(By.id("jsx-iframe-31f12e0e20"));
		 * 
		 * driver.switchTo().frame(frame1);
		 * 
		 * driver.findElement(By.xpath("//*[@id=\"buttons-container\"]/div/div[1]/div"))
		 * .click();
		 */

	}

	@Test
	public void Test008_As_BookerwithSubmitand_InvalidDetails() throws InterruptedException {
		home_page = new Home_Page();

		home_page.clickonregisterTab();

		ticket_page = new Ticket_Register_Page();

		Thread.sleep(2000);

		// click on Table of 10 Buy Option
		ticket_page.clickonBuyoptionTableofTen();

		// Click on yes radio button
		ticket_page.clickOnYesradiobtn();

		// Enter Username
		ticket_page.enteremail("sumit.koli1@conv.in");

		// Enter Password
		ticket_page.enterPassword("12345");

		// Click on Submit Button
		ticket_page.clickSubmit();

		registration_page = new Registration_Page();

		// Enter Table Name
		registration_page.enterTablename("Test Table");

		for (int i = 1; i <= 5; i++) {
			driver.findElement(By.id("first_name_" + i)).sendKeys("Jack" + i);
			driver.findElement(By.id("last_name_" + i)).sendKeys("Jones" + i);
			driver.findElement(By.id("email_" + i)).sendKeys("jack" + i + "@gmail.com");
			driver.findElement(By.id("job_title_" + i)).sendKeys("BA" + i);
			driver.findElement(By.id("phone_" + i)).sendKeys("234567823" + i);
			driver.findElement(By.id("company_" + i)).sendKeys("CDADD" + i);

			WebElement registrationCategory = driver.findElement(By.id("registration_category_" + i));

			Select dropdown1 = new Select(registrationCategory);

			dropdown1.selectByIndex(1);

			WebElement dietaryreq = driver.findElement(By.id("dietary_requirements_" + i));

			Select dropdown2 = new Select(dietaryreq);

			dropdown2.selectByIndex(1);
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		// Click on Accept Terms and condition
		registration_page.clickOntermsandCondt();

		Thread.sleep(2000);
		// Click on Submit button
		registration_page.clickOnSubmitbtn();

		String actual = driver.switchTo().alert().getText();

		System.out.println(actual);
		driver.switchTo().alert().accept();

		String expected = "Please enter a minimum of 7 member details to proceed further!";

		Assert.assertEquals(actual, expected);

	}

	@Test
	public void Test009_As_BookerwithSaveand_ValidDetails() throws InterruptedException {
		home_page = new Home_Page();

		home_page.clickonregisterTab();

		ticket_page = new Ticket_Register_Page();

		Thread.sleep(2000);

		// click on Table of 10 Buy Option
		ticket_page.clickonBuyoptionTableofTen();

		// Click on yes radio button
		ticket_page.clickOnYesradiobtn();

		// Enter Username
		ticket_page.enteremail("sumit.koli1@conv.in");

		// Enter Password
		ticket_page.enterPassword("12345");

		// Click on Submit Button
		ticket_page.clickSubmit();

		registration_page = new Registration_Page();

		// Enter Table Name
		registration_page.enterTablename("Test Table");

		for (int i = 1; i <= 4; i++) {
			driver.findElement(By.id("first_name_" + i)).sendKeys("Jack" + i);
			driver.findElement(By.id("last_name_" + i)).sendKeys("Jones" + i);
			driver.findElement(By.id("email_" + i)).sendKeys("jack" + i + "@gmail.com");
			driver.findElement(By.id("job_title_" + i)).sendKeys("BA" + i);
			driver.findElement(By.id("phone_" + i)).sendKeys("234567823" + i);
			driver.findElement(By.id("company_" + i)).sendKeys("CDADD" + i);

			WebElement registrationCategory = driver.findElement(By.id("registration_category_" + i));

			Select dropdown1 = new Select(registrationCategory);

			dropdown1.selectByIndex(1);

			WebElement dietaryreq = driver.findElement(By.id("dietary_requirements_" + i));

			Select dropdown2 = new Select(dietaryreq);

			dropdown2.selectByIndex(1);

		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");

		// Click on term and Conditions
		registration_page.clickOntermsandCondt();

		// Click on Save Button
		Thread.sleep(2000);
		registration_page.clickonSaveBtn();

		driver.switchTo().alert().accept();

		String actual = driver.findElement(By.xpath("//p[@class='thanksp']")).getText();

		System.out.println(actual);

		String expected = "Please review your registration information for event Project Control Expo 2022.\n"
				+ "If they are correct, please proceed with the payment.";

		Assert.assertEquals(actual, expected);

	}

	@Test
	public void Test010_As_BookerwithSaveand_InvalidDetails() throws InterruptedException {
		home_page = new Home_Page();

		home_page.clickonregisterTab();

		ticket_page = new Ticket_Register_Page();

		Thread.sleep(2000);

		// click on Table of 10 Buy Option
		ticket_page.clickonBuyoptionTableofTen();

		// Click on yes radio button
		ticket_page.clickOnYesradiobtn();

		// Enter Username
		ticket_page.enteremail("sumit.koli1@conv.in");

		// Enter Password
		ticket_page.enterPassword("12345");

		// Click on Submit Button
		ticket_page.clickSubmit();

		registration_page = new Registration_Page();

		// Enter Table Name
		registration_page.enterTablename("Test Table");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");

		// Click on term and Conditions
		registration_page.clickOntermsandCondt();

		// Click on Save Button
		Thread.sleep(2000);
		registration_page.clickonSaveBtn();

		String actual = driver.switchTo().alert().getText();

		System.out.println(actual);

		String expected = "Please enter a minimum of 1 member details to proceed further!";

		Assert.assertEquals(actual, expected);

		driver.switchTo().alert().accept();
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void Test011_As_BookerandMemberwithSubmitand_ValidDetails() throws InterruptedException {
		home_page = new Home_Page();

		home_page.clickonregisterTab();

		ticket_page = new Ticket_Register_Page();

		Thread.sleep(2000);

		// click on Table of 10 Buy Option
		ticket_page.clickonBuyoptionTableofTen();

		// Click on yes radio button
		ticket_page.clickOnYesradiobtn();

		// Enter Username
		ticket_page.enteremail("sumit.koli1@conv.in");

		// Enter Password
		ticket_page.enterPassword("12345");

		// Click on Submit Button
		ticket_page.clickSubmit();

		registration_page = new Registration_Page();

		// Enter Table Name
		registration_page.enterTablename("Test Table");

		registration_page.clickonAreyouamemberofthistable();

		WebElement dietaryreq1 = driver.findElement(By.id("dietary_requirements_1"));

		Select dropdown = new Select(dietaryreq1);

		dropdown.selectByIndex(1);

		for (int i = 2; i <= 10; i++) {
			driver.findElement(By.id("first_name_" + i)).sendKeys("Jack" + i);
			driver.findElement(By.id("last_name_" + i)).sendKeys("Jones" + i);
			driver.findElement(By.id("email_" + i)).sendKeys("jack" + i + "@gmail.com");
			driver.findElement(By.id("job_title_" + i)).sendKeys("BA" + i);
			driver.findElement(By.id("phone_" + i)).sendKeys("234567823" + i);
			driver.findElement(By.id("company_" + i)).sendKeys("CDADD" + i);

			WebElement registrationCategory = driver.findElement(By.id("registration_category_" + i));

			Select dropdown1 = new Select(registrationCategory);

			dropdown1.selectByIndex(1);

			WebElement dietaryreq = driver.findElement(By.id("dietary_requirements_" + i));

			Select dropdown2 = new Select(dietaryreq);

			dropdown2.selectByIndex(1);
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		registration_page.clickOntermsandCondt();

		registration_page.clickOnSubmitbtn();

		driver.switchTo().alert().accept();

		// Purchase Page
		purchase_page = new Purchase_Page();

		js.executeScript("window.scrollBy(0,2000)");

		Thread.sleep(2000);
		purchase_page.clickonSubmitbtn();

	}

	@Test
	public void Test012_As_BookerandMemberwithSubmitand_InvalidDetails() throws InterruptedException {
		home_page = new Home_Page();

		home_page.clickonregisterTab();

		ticket_page = new Ticket_Register_Page();

		Thread.sleep(2000);

		// click on Table of 10 Buy Option
		ticket_page.clickonBuyoptionTableofTen();

		// Click on yes radio button
		ticket_page.clickOnYesradiobtn();

		// Enter Username
		ticket_page.enteremail("sumit.koli1@conv.in");

		// Enter Password
		ticket_page.enterPassword("12345");

		// Click on Submit Button
		ticket_page.clickSubmit();

		registration_page = new Registration_Page();

		// Enter Table Name
		registration_page.enterTablename("Test Table");

		registration_page.clickonAreyouamemberofthistable();

		WebElement dietaryreq1 = driver.findElement(By.id("dietary_requirements_1"));

		Select dropdown = new Select(dietaryreq1);

		dropdown.selectByIndex(1);

		for (int i = 2; i <= 4; i++) {
			driver.findElement(By.id("first_name_" + i)).sendKeys("Jack" + i);
			driver.findElement(By.id("last_name_" + i)).sendKeys("Jones" + i);
			driver.findElement(By.id("email_" + i)).sendKeys("jack" + i + "@gmail.com");
			driver.findElement(By.id("job_title_" + i)).sendKeys("BA" + i);
			driver.findElement(By.id("phone_" + i)).sendKeys("234567823" + i);
			driver.findElement(By.id("company_" + i)).sendKeys("CDADD" + i);

			WebElement registrationCategory = driver.findElement(By.id("registration_category_" + i));

			Select dropdown1 = new Select(registrationCategory);

			dropdown1.selectByIndex(1);

			WebElement dietaryreq = driver.findElement(By.id("dietary_requirements_" + i));

			Select dropdown2 = new Select(dietaryreq);

			dropdown2.selectByIndex(1);
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		// Click on Accept Terms and condition
		registration_page.clickOntermsandCondt();

		Thread.sleep(2000); // Click on Submit button
		registration_page.clickOnSubmitbtn();

		String actual = driver.switchTo().alert().getText();

		System.out.println(actual);
		driver.switchTo().alert().accept();

		String expected = "Please enter a minimum of 7 member details to proceed further!";

		Assert.assertEquals(actual, expected);

	}

	@Test
	public void Test013_As_BookerandMemberwithSaveand_ValidDetails() throws InterruptedException {
		home_page = new Home_Page();

		home_page.clickonregisterTab();

		ticket_page = new Ticket_Register_Page();

		Thread.sleep(2000);

		// click on Table of 10 Buy Option
		ticket_page.clickonBuyoptionTableofTen();

		// Click on yes radio button
		ticket_page.clickOnYesradiobtn();

		// Enter Username
		ticket_page.enteremail("sumit.koli1@conv.in");

		// Enter Password
		ticket_page.enterPassword("12345");

		// Click on Submit Button
		ticket_page.clickSubmit();

		registration_page = new Registration_Page();

		// Enter Table Name
		registration_page.enterTablename("Test Table");

		registration_page.clickonAreyouamemberofthistable();

		WebElement dietaryreq1 = driver.findElement(By.id("dietary_requirements_1"));

		Select dropdown = new Select(dietaryreq1);

		dropdown.selectByIndex(1);

		for (int i = 2; i <= 4; i++) {
			driver.findElement(By.id("first_name_" + i)).sendKeys("Jack" + i);
			driver.findElement(By.id("last_name_" + i)).sendKeys("Jones" + i);
			driver.findElement(By.id("email_" + i)).sendKeys("jack" + i + "@gmail.com");
			driver.findElement(By.id("job_title_" + i)).sendKeys("BA" + i);
			driver.findElement(By.id("phone_" + i)).sendKeys("234567823" + i);
			driver.findElement(By.id("company_" + i)).sendKeys("CDADD" + i);

			WebElement registrationCategory = driver.findElement(By.id("registration_category_" + i));

			Select dropdown1 = new Select(registrationCategory);

			dropdown1.selectByIndex(1);

			WebElement dietaryreq = driver.findElement(By.id("dietary_requirements_" + i));

			Select dropdown2 = new Select(dietaryreq);

			dropdown2.selectByIndex(1);

		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");

		// Click on term and Conditions
		registration_page.clickOntermsandCondt();

		// Click on Save Button
		Thread.sleep(2000);
		registration_page.clickonSaveBtn();

		driver.switchTo().alert().accept();

		String actual = driver.findElement(By.xpath("//p[@class='thanksp']")).getText();

		System.out.println(actual);

		String expected = "Please review your registration information for event Project Control Expo 2022.\n"
				+ "If they are correct, please proceed with the payment.";

		Assert.assertEquals(actual, expected);

	}

//______________________________________________________________________---------------------------------------------------------------------------------------

	@Test
	public void Test014_As_BookerandMemberwithSubmitand_50percentCoupenCode() throws InterruptedException {
		home_page = new Home_Page();

		home_page.clickonregisterTab();

		ticket_page = new Ticket_Register_Page();

		Thread.sleep(2000);

		String value = "//body/div[@id='wrapper']/div[@id='wrapperinner']/div[@id='area']/div[@id='areainner']/div[@id='contentarea']/div[1]/div[2]/div[4]/div[1]/div[1]/p[1]";

		String rvalue = driver.findElement(By.xpath(value)).getText().split(" ")[1];

		double price = Integer.parseInt(rvalue);

		System.out.println(price);

		double gst = price * 0.10;

		double totalPrice = price + gst;

		double coupenCode = 50.0;

		double FinalPrice = totalPrice - ((totalPrice * coupenCode) / 100);

		System.out.println(FinalPrice);

		// click on Table of 10 Buy Option
		ticket_page.clickonBuyoptionTableofTen();

		// Click on yes radio button
		ticket_page.clickOnYesradiobtn();

		// Enter Username
		ticket_page.enteremail("sumit.koli1@conv.in");

		// Enter Password
		ticket_page.enterPassword("12345");

		// Click on Submit Button
		ticket_page.clickSubmit();

		registration_page = new Registration_Page();

		// Enter Table Name
		registration_page.enterTablename("Test Table");

		registration_page.clickonAreyouamemberofthistable();

		registration_page.entercoupencode("WS50");

		WebElement dietaryreq1 = driver.findElement(By.id("dietary_requirements_1"));

		Select dropdown = new Select(dietaryreq1);

		dropdown.selectByIndex(1);

		for (int i = 2; i <= 10; i++) {
			driver.findElement(By.id("first_name_" + i)).sendKeys("Jack" + i);
			driver.findElement(By.id("last_name_" + i)).sendKeys("Jones" + i);
			driver.findElement(By.id("email_" + i)).sendKeys("jack" + i + "@gmail.com");
			driver.findElement(By.id("job_title_" + i)).sendKeys("BA" + i);
			driver.findElement(By.id("phone_" + i)).sendKeys("234567823" + i);
			driver.findElement(By.id("company_" + i)).sendKeys("CDADD" + i);

			WebElement registrationCategory = driver.findElement(By.id("registration_category_" + i));

			Select dropdown1 = new Select(registrationCategory);

			dropdown1.selectByIndex(1);

			WebElement dietaryreq = driver.findElement(By.id("dietary_requirements_" + i));

			Select dropdown2 = new Select(dietaryreq);

			dropdown2.selectByIndex(1);
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		registration_page.clickOntermsandCondt();

		registration_page.clickOnSubmitbtn();

		driver.switchTo().alert().accept();

		// Purchase Page
		purchase_page = new Purchase_Page();

		js.executeScript("window.scrollBy(0,2000)");

		Thread.sleep(2000);

		// purchase_page.clickonSubmitbtn();

		String actual = driver.findElement(By.xpath("//p[@class='thanksp']")).getText();

		System.out.println(actual);

		String expected = "Please review your registration information for event Project Control Expo 2022.\n"
				+ "If they are correct, please proceed with the payment.";

		Assert.assertEquals(actual, expected);

		String value1 = "//body[1]/div[5]/div[1]/div[2]/div[1]/div[2]/div[3]/form[1]/div[4]/table[1]/tbody[1]/tr[5]/td[2]";

		String price1 = driver.findElement(By.xpath(value1)).getText().split("\\$")[1];

		System.out.println(price1);

		double FinalPrice1 = Double.parseDouble(price1);

		Assert.assertEquals(FinalPrice, FinalPrice1);

	}

	@Test
	public void Test015_As_BookerandMemberwithSubmitand_100percentCoupenCode() throws InterruptedException {
		home_page = new Home_Page();

		home_page.clickonregisterTab();

		ticket_page = new Ticket_Register_Page();

		Thread.sleep(2000);

		String value = "//body/div[@id='wrapper']/div[@id='wrapperinner']/div[@id='area']/div[@id='areainner']/div[@id='contentarea']/div[1]/div[2]/div[4]/div[1]/div[1]/p[1]";

		String rvalue = driver.findElement(By.xpath(value)).getText().split(" ")[1];

		int price = Integer.parseInt(rvalue);

		System.out.println(price);

		double gst = price * 0.10;

		double totalPrice = price + gst;

		double coupenCode = 100.0;

		double FinalPrice = totalPrice - ((totalPrice * coupenCode) / 100);

		System.out.println(FinalPrice);

		// click on Table of 10 Buy Option
		ticket_page.clickonBuyoptionTableofTen();

		// Click on yes radio button
		ticket_page.clickOnYesradiobtn();

		// Enter Username
		ticket_page.enteremail("sumit.koli1@conv.in");

		// Enter Password
		ticket_page.enterPassword("12345");

		// Click on Submit Button
		ticket_page.clickSubmit();

		registration_page = new Registration_Page();

		// aas
		// Enter Table Name
		registration_page.enterTablename("Test Table");

		registration_page.clickonAreyouamemberofthistable();

		registration_page.entercoupencode("WS100");

		WebElement dietaryreq1 = driver.findElement(By.id("dietary_requirements_1"));

		Select dropdown = new Select(dietaryreq1);

		dropdown.selectByIndex(1);

		for (int i = 2; i <= 10; i++) {
			driver.findElement(By.id("first_name_" + i)).sendKeys("Jack" + i);
			driver.findElement(By.id("last_name_" + i)).sendKeys("Jones" + i);
			driver.findElement(By.id("email_" + i)).sendKeys("jack" + i + "@gmail.com");
			driver.findElement(By.id("job_title_" + i)).sendKeys("BA" + i);
			driver.findElement(By.id("phone_" + i)).sendKeys("234567823" + i);
			driver.findElement(By.id("company_" + i)).sendKeys("CDADD" + i);

			WebElement registrationCategory = driver.findElement(By.id("registration_category_" + i));

			Select dropdown1 = new Select(registrationCategory);

			dropdown1.selectByIndex(1);

			WebElement dietaryreq = driver.findElement(By.id("dietary_requirements_" + i));

			Select dropdown2 = new Select(dietaryreq);

			dropdown2.selectByIndex(1);
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		registration_page.clickOntermsandCondt();

		registration_page.clickOnSubmitbtn();

		driver.switchTo().alert().accept();

		// Purchase Page
		purchase_page = new Purchase_Page();

		js.executeScript("window.scrollBy(0,2000)");

		Thread.sleep(2000);

		// purchase_page.clickonSubmitbtn();

		String actual = driver.findElement(By.xpath("//p[@class='thanksp']")).getText();

		System.out.println(actual);

		String expected = "Please review your registration information for event Project Control Expo 2022.\n"
				+ "If they are correct, please proceed with the payment.";

		Assert.assertEquals(actual, expected);

		String value1 = "//body[1]/div[5]/div[1]/div[2]/div[1]/div[2]/div[3]/form[1]/div[4]/table[1]/tbody[1]/tr[5]/td[2]";

		String price1 = driver.findElement(By.xpath(value1)).getText().split("\\$")[1];

		System.out.println(price1);

		double FinalPrice1 = Double.parseDouble(price1);

		Assert.assertEquals(FinalPrice, FinalPrice1);

	}

	@Test
	public void Test016_As_BookerandMemberwithSubmitand_InvalidCoupenCode() throws InterruptedException {
		home_page = new Home_Page();

		home_page.clickonregisterTab();

		ticket_page = new Ticket_Register_Page();

		Thread.sleep(2000);

		// click on Table of 10 Buy Option
		ticket_page.clickonBuyoptionTableofTen();

		// Click on yes radio button
		ticket_page.clickOnYesradiobtn();

		// Enter Username
		ticket_page.enteremail("sumit.koli1@conv.in");

		// Enter Password
		ticket_page.enterPassword("12345");

		// Click on Submit Button
		ticket_page.clickSubmit();

		registration_page = new Registration_Page();

		// Enter Table Name
		registration_page.enterTablename("Test Table");

		//Enter Coupon Code
		registration_page.entercoupencode("WSddj");

		// Coupon text validation
		String actual = driver.findElement(By.xpath("//span[@id='coupon_code_check']")).getText();

		String expected = "The coupon you entered is invalid";

		Assert.assertEquals(actual, expected);

	}
}
