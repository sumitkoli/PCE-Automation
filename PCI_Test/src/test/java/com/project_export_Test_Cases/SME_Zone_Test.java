package com.project_export_Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.project_expoert_BaseClass.Base_Class;
import com.project_export_Page_Object.Home_Page;
import com.project_export_Page_Object.SME_Zone_Page;

public class SME_Zone_Test extends Base_Class {

	Home_Page home_page;
	SME_Zone_Page sme_zone;

	//@Test
	public void Test020_Send_Q_to_Speaker() throws InterruptedException {

		home_page = new Home_Page();

		home_page.move_To_Expo_Tab();

		home_page.click_On_SME_Zone();
		
		WebElement frame1 = driver.findElement(By.xpath(
				"//body/div[@id='wrapper']/div[@id='wrapperinner']/div[@id='area']/div[@id='areainner']/div[@id='contentarea']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/iframe[1]"));

		driver.switchTo().frame(frame1);
		
		sme_zone =new SME_Zone_Page();
		
		sme_zone.enter_Name("Jack");
		
		sme_zone.enter_EmailId("jack@gmail.com");
		
		sme_zone.enter_Contactno("6622334");
		
		sme_zone.enter_Message("Test");
		
		sme_zone.select_Speaker("Lilah Torres");
		
		sme_zone.click_SubmitBtn();
		
		Thread.sleep(2000);
		String actual = driver.findElement(By.xpath("//*[@id=\"system-message\"]/div/div/div"))
				.getText();

		System.out.println(actual);

		String expected = "     Data Saved Successfully.";

		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void Test021_Send_Q_to_SME() throws InterruptedException {

		home_page = new Home_Page();

		home_page.move_To_Expo_Tab();

		home_page.click_On_SME_Zone();
		
		WebElement frame1 = driver.findElement(By.xpath(
				"//*[@id=\"contentarea\"]/div/div/div/div[2]/div[2]/iframe"));

		driver.switchTo().frame(frame1);
		
		sme_zone =new SME_Zone_Page();
		
		sme_zone.enter_Name("Jack");
		
		sme_zone.enter_EmailId("jack@gmail.com");
		
		sme_zone.enter_Contactno("6622334");
		
		sme_zone.enter_Message("Test");
		
		sme_zone.select_SME("TBC");
		
		sme_zone.click_SubmitBtn();
		
		Thread.sleep(2000);
		String actual = driver.findElement(By.xpath("//body/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]"))
				.getText();

		System.out.println(actual);

		String expected = "     Data Saved Successfully.";

		Assert.assertEquals(actual, expected);
	}
}
