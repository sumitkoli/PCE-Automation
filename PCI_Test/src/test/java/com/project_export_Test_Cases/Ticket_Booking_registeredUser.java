package com.project_export_Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project_expoert_BaseClass.Base_Class;
import com.project_export_Driver_Action.Action_Driver;
import com.project_export_Page_Object.Home_Page;
import com.project_export_Page_Object.Purchase_Page;
import com.project_export_Page_Object.Registration_Page;
import com.project_export_Page_Object.Ticket_Register_Page;

public class Ticket_Booking_registeredUser extends Base_Class {

	Home_Page home_page;
	Ticket_Register_Page ticket_page;
	Registration_Page registration_page;
	Purchase_Page purchase_page;
	Action_Driver action_driver;

	@Test
	public void Test001_ticketBookingRegisteredUser_withValidDetails() throws InterruptedException {
		home_page = new Home_Page();

		home_page.clickonregisterTab();

		ticket_page = new Ticket_Register_Page();

		Thread.sleep(2000);

		// Clicking on Buy option
		ticket_page.clickonBuyoptionIndividualTicket();

		// Click on yes radio button
		ticket_page.clickOnYesradiobtn();

		// Enter Username
		ticket_page.enteremail("sumit.koli1@conv.in");

		// Enter Password
		ticket_page.enterPassword("12345");

		// Click on Submit Button
		ticket_page.clickSubmit();

		registration_page = new Registration_Page();

		// Scroll Down
		action_driver = new Action_Driver();
		action_driver.javascript_Executor("window.scrollBy(0,500)");

		// Stadium Tour Select
		WebElement stadium = driver.findElement(By.xpath("//select[@id='do-you-wish-to-join-mcg-stadium-tour']"));

		Select dropdown1 = new Select(stadium);

		dropdown1.selectByIndex(1);

		System.out.println(dropdown1.getFirstSelectedOption().getText());

		// Cookies Dismiss
		driver.findElement(By.xpath("//a[@class='cc-btn cc-dismiss']")).click();

		// Accept on Terms and condition
		registration_page.clickOntermsandCondt();

		// Click on Submit Button
		registration_page.clickOnSubmitbtn();

		// Thread.sleep(2000);

		purchase_page = new Purchase_Page();

		String actual = driver.findElement(By.xpath("//p[@class='thanksp']")).getText();

		System.out.println(actual);

		String expected = "Please review your registration information for event Project Control Expo 2022.\n"
				+ "If they are correct, please proceed with the payment.";

		Assert.assertEquals(actual, expected);

		// Click on Payment Button
		purchase_page.clickonSubmitbtn();

//		WebElement frameID = driver.findElement(By.xpath("//*[@id=\"jsx-iframe-260fde8b42\"]"));
//
//		driver.switchTo().frame(frameID);
//
//		driver.findElement(By.xpath("//*[@id=\"buttons-container\"]/div/div[2]/div/div[1]/span[2]")).click();

	}

	@Test
	public void Test002_ticketBookingRegisteredUser_withInvalidDetails() throws InterruptedException {
		home_page = new Home_Page();

		home_page.clickonregisterTab();

		ticket_page = new Ticket_Register_Page();

		Thread.sleep(2000);

		// Clicking on Buy option
		ticket_page.clickonBuyoptionIndividualTicket();

		// Click on yes radio button
		ticket_page.clickOnYesradiobtn();

		// Enter Username
		ticket_page.enteremail("sumit.koli1@conv.in");

		// Enter Password
		ticket_page.enterPassword("12345");

		// Click on Submit Button
		ticket_page.clickSubmit();

		registration_page = new Registration_Page();

		/// Scroll down
		action_driver = new Action_Driver();
		action_driver.javascript_Executor("window.scrollBy(0,500)");

		// Cookies Dismiss
		driver.findElement(By.xpath("//a[@class='cc-btn cc-dismiss']")).click();

		// Accept on Terms and condition
		registration_page.clickOntermsandCondt();

		// Click on Submit Button
		registration_page.clickOnSubmitbtn();

		String actual = driver.switchTo().alert().getText();

		System.out.println(actual);

		String expected = "Please fill in all the required details.";

		Assert.assertEquals(actual, expected);

		// Accept the alert
		driver.switchTo().alert().accept();

	}

//----------------------------------------------------------------------------------------------------------------------------------------------------------------	

	@Test
	public void Test003_ticketBookingRegisteredUser_with50percentValidCoupenCodeDetails() throws InterruptedException {
		home_page = new Home_Page();

		home_page.clickonregisterTab();

		ticket_page = new Ticket_Register_Page();

		Thread.sleep(2000);

		// Scroll Down
		action_driver = new Action_Driver();
		action_driver.javascript_Executor("window.scrollBy(0,500)");

		String value = "//body/div[@id='wrapper']/div[@id='wrapperinner']/div[@id='area']/div[@id='areainner']/div[@id='contentarea']/div[1]/div[2]/div[2]/div[1]/div[1]/p[1]";

		String rvalue = driver.findElement(By.xpath(value)).getText().split(" ")[1];

		int price = Integer.parseInt(rvalue);

		System.out.println(price);

		double gst = price * 0.10;

		double totalPrice = price + gst;

		double coupenCode = 50.0;

		double FinalPrice = totalPrice - ((totalPrice * coupenCode) / 100);

		System.out.println(FinalPrice);

		// Clicking on Buy option
		ticket_page.clickonBuyoptionIndividualTicket();

		// Click on yes radio button
		ticket_page.clickOnYesradiobtn();

		// Enter Username
		ticket_page.enteremail("sumit.koli1@conv.in");

		// Enter Password
		ticket_page.enterPassword("12345");

		// Click on Submit Button
		ticket_page.clickSubmit();

		registration_page = new Registration_Page();

		action_driver.javascript_Executor("window.scrollBy(0,500)");

		// Stadium Tour Select
		WebElement stadium = driver.findElement(By.xpath("//select[@id='do-you-wish-to-join-mcg-stadium-tour']"));

		Select dropdown1 = new Select(stadium);

		dropdown1.selectByIndex(2);

		System.out.println(dropdown1.getFirstSelectedOption().getText());

		registration_page.entercoupencode("WSS50");

		// Cookies Dismiss
		driver.findElement(By.xpath("//a[@class='cc-btn cc-dismiss']")).click();

		// Accept on Terms and condition
		registration_page.clickOntermsandCondt();

		// Click on Submit Button
		registration_page.clickOnSubmitbtn();

		// Thread.sleep(2000);

		purchase_page = new Purchase_Page();

		String actual = driver.findElement(By.xpath("//p[@class='thanksp']")).getText();

		System.out.println(actual);

		String expected = "Please review your registration information for event Project Control Expo 2022.\n"
				+ "If they are correct, please proceed with the payment.";

		Assert.assertEquals(actual, expected);

		String value1 = "//*[@id=\"noaddons-table\"]/table/tbody/tr[5]/td[2]";

		String price1 = driver.findElement(By.xpath(value1)).getText().split("\\$")[1];

		System.out.println(price1);

		double FinalPrice1 = Double.parseDouble(price1);

		Assert.assertEquals(FinalPrice, FinalPrice1);

		// Click on Payment Button
		// purchase_page.clickonSubmitbtn();

	}

	@Test
	public void Test004_ticketBookingRegisteredUser_with100percentValidCoupenCodeDetails() throws InterruptedException {
		home_page = new Home_Page();

		home_page.clickonregisterTab();

		ticket_page = new Ticket_Register_Page();

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");

		String value = "//body/div[@id='wrapper']/div[@id='wrapperinner']/div[@id='area']/div[@id='areainner']/div[@id='contentarea']/div[1]/div[2]/div[2]/div[1]/div[1]/p[1]";

		String rvalue = driver.findElement(By.xpath(value)).getText().split(" ")[1];

		int price = Integer.parseInt(rvalue);

		System.out.println(price);

		double gst = price * 0.10;

		double totalPrice = price + gst;

		double coupenCode = 100.0;

		double FinalPrice = totalPrice - ((totalPrice * coupenCode) / 100);

		System.out.println(FinalPrice);

		// Clicking on Buy option
		ticket_page.clickonBuyoptionIndividualTicket();

		// Click on yes radio button
		ticket_page.clickOnYesradiobtn();

		// Enter Username
		ticket_page.enteremail("sumit.koli1@conv.in");

		// Enter Password
		ticket_page.enterPassword("12345");

		// Click on Submit Button
		ticket_page.clickSubmit();

		registration_page = new Registration_Page();

		js.executeScript("window.scrollBy(0,500)");

		// Stadium Tour Select
		WebElement stadium = driver.findElement(By.xpath("//select[@id='do-you-wish-to-join-mcg-stadium-tour']"));

		Select dropdown1 = new Select(stadium);

		dropdown1.selectByIndex(2);

		System.out.println(dropdown1.getFirstSelectedOption().getText());

		registration_page.entercoupencode("WSS100");

		// Cookies Dismiss
		driver.findElement(By.xpath("//a[@class='cc-btn cc-dismiss']")).click();

		// Accept on Terms and condition
		registration_page.clickOntermsandCondt();

		// Click on Submit Button
		registration_page.clickOnSubmitbtn();

		// Thread.sleep(2000);

		purchase_page = new Purchase_Page();

		String actual = driver.findElement(By.xpath("//p[@class='thanksp']")).getText();

		System.out.println(actual);

		String expected = "Please review your registration information for event Project Control Expo 2022.\n"
				+ "If they are correct, please proceed with the payment.";

		Assert.assertEquals(actual, expected);

		String value1 = "//*[@id=\"noaddons-table\"]/table/tbody/tr[5]/td[2]";

		String price1 = driver.findElement(By.xpath(value1)).getText().split("\\$")[1];

		System.out.println(price1);

		double FinalPrice1 = Double.parseDouble(price1);

		Assert.assertEquals(FinalPrice, FinalPrice1);

		// Click on Payment Button
		// purchase_page.clickonSubmitbtn();

	}

	@Test
	public void Test005_ticketBookingRegisteredUser_withInvalidCoupenCodeDetails() throws InterruptedException {
		home_page = new Home_Page();

		home_page.clickonregisterTab();

		ticket_page = new Ticket_Register_Page();

		Thread.sleep(2000);

		// Clicking on Buy option
		ticket_page.clickonBuyoptionIndividualTicket();

		// Click on yes radio button
		ticket_page.clickOnYesradiobtn();

		// Enter Username
		ticket_page.enteremail("sumit.koli1@conv.in");

		// Enter Password
		ticket_page.enterPassword("12345");

		// Click on Submit Button
		ticket_page.clickSubmit();

		registration_page = new Registration_Page();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		// Stadium Tour Select
		WebElement stadium = driver.findElement(By.xpath("//select[@id='do-you-wish-to-join-mcg-stadium-tour']"));

		Select dropdown1 = new Select(stadium);

		dropdown1.selectByIndex(1);

		System.out.println(dropdown1.getFirstSelectedOption().getText());

		registration_page.entercoupencode("AD00");

		// Cookies Dismiss
		driver.findElement(By.xpath("//a[@class='cc-btn cc-dismiss']")).click();

		// Accept on Terms and condition
		registration_page.clickOntermsandCondt();

		// Click on Submit Button
		registration_page.clickOnSubmitbtn();

		// Coupon text validation
		String actual = driver.findElement(By.xpath("//span[@id='coupon_code_check']")).getText();

		String expected = "The coupon you entered is invalid";

		Assert.assertEquals(actual, expected);

	}

//-------------------------------------------------------------------------------------------------------------------------------------------------------------	

	@Test
	public void Test006_ticketBookingRegisteredUser_withStadiumTour() throws InterruptedException {
		home_page = new Home_Page();

		home_page.clickonregisterTab();

		ticket_page = new Ticket_Register_Page();

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");

		String value = "//body/div[@id='wrapper']/div[@id='wrapperinner']/div[@id='area']/div[@id='areainner']/div[@id='contentarea']/div[1]/div[2]/div[2]/div[1]/div[1]/p[1]";

		String rvalue = driver.findElement(By.xpath(value)).getText().split(" ")[1];

		double eventPrice = Double.parseDouble(rvalue);

		System.out.println(eventPrice);

		// Clicking on Buy option
		ticket_page.clickonBuyoptionIndividualTicket();

		// Click on yes radio button
		ticket_page.clickOnYesradiobtn();

		// Enter Username
		ticket_page.enteremail("sumit.koli1@conv.in");

		// Enter Password
		ticket_page.enterPassword("12345");

		// Click on Submit Button
		ticket_page.clickSubmit();

		registration_page = new Registration_Page();

		js.executeScript("window.scrollBy(0,500)");

		// Stadium Tour Select
		WebElement stadium = driver.findElement(By.xpath("//select[@id='do-you-wish-to-join-mcg-stadium-tour']"));

		Select dropdown1 = new Select(stadium);

		dropdown1.selectByIndex(1);

		System.out.println(dropdown1.getFirstSelectedOption().getText());

		// registration_page.entercoupencode("WSS100");

		// Cookies Dismiss
		driver.findElement(By.xpath("//a[@class='cc-btn cc-dismiss']")).click();

		// Accept on Terms and condition
		registration_page.clickOntermsandCondt();

		// Click on Submit Button
		registration_page.clickOnSubmitbtn();

		// Thread.sleep(2000);

		// Purchase Page
		purchase_page = new Purchase_Page();

		String actual = driver.findElement(By.xpath("//p[@class='thanksp']")).getText();

		System.out.println(actual);

		String expected = "Please review your registration information for event Project Control Expo 2022.\n"
				+ "If they are correct, please proceed with the payment.";

		Assert.assertEquals(actual, expected);

		// Stadium Tour value
		String stadiumgetvalue = driver.findElement(By.xpath(
				"//body[1]/div[5]/div[1]/div[2]/div[1]/div[2]/div[3]/form[1]/div[3]/table[1]/tbody[1]/tr[3]/td[2]"))
				.getText().split("\\$")[1];

		double stadiumTourPrice = Double.parseDouble(stadiumgetvalue);

		System.out.println(stadiumTourPrice);

		double TotalPrice = eventPrice + stadiumTourPrice;

		double gst = TotalPrice * 0.10;

		double FinalPrice = TotalPrice + gst;

		System.out.println(FinalPrice);

		// Final Value
		String value1 = "/html[1]/body[1]/div[5]/div[1]/div[2]/div[1]/div[2]/div[3]/form[1]/div[3]/table[1]/tbody[1]/tr[6]/td[2]";

		String price1 = driver.findElement(By.xpath(value1)).getText().split("\\$")[1];

		System.out.println(price1);

		double FinalPrice1 = Double.parseDouble(price1);

		System.out.println(FinalPrice1);

		Assert.assertEquals(FinalPrice, FinalPrice1);

	}

}
