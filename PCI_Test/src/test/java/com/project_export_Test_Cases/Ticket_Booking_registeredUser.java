package com.project_export_Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project_expoert_BaseClass.Base_Class;
import com.project_export_Page_Object.Home_Page;
import com.project_export_Page_Object.Purchase_Page;
import com.project_export_Page_Object.Registration_Page;
import com.project_export_Page_Object.Ticket_Register_Page;

public class Ticket_Booking_registeredUser extends Base_Class {

	Home_Page home_page;
	Ticket_Register_Page ticket_page;
	Registration_Page registration_page;
	Purchase_Page purchase_page;

	@Test
	public void ticketBookingRegisteredUser() throws InterruptedException {
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

		// Cookies Dismiss
		driver.findElement(By.xpath("//a[@class='cc-btn cc-dismiss']")).click();

		// Accept on Terms and condition
		registration_page.clickOntermsandCondt();

		// Click on Submit Button
		registration_page.clickOnSubmitbtn();

		// Thread.sleep(2000);

		purchase_page = new Purchase_Page();

		// Click on Payment Button
		purchase_page.clickonSubmitbtn();

		WebElement frameID = driver.findElement(By.xpath("//*[@id=\"jsx-iframe-260fde8b42\"]"));

		driver.switchTo().frame(frameID);

		driver.findElement(By.xpath("//*[@id=\"buttons-container\"]/div/div[2]/div/div[1]/span[2]")).click();

	}
}
