package com.project_export_Page_Object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project_expoert_BaseClass.Base_Class;

public class Ticket_Register_Page extends Base_Class {

	public Ticket_Register_Page() {
		PageFactory.initElements(driver, this);
	}
	
	//Click on Second Individual ticket Buy option
	@FindBy(xpath="//a[@data-ticket_id='47']")
	WebElement bookticket;
	
	@FindBy(xpath="//a[@data-ticket_id='49']")
	WebElement tableof10;
	
	//Click on Yes Button
	@FindBy(xpath="//span[@class='checkmark']")
	WebElement radioYesbtn;
	
	//Click on No Button
	@FindBy(xpath="//body/div[@id='wrapper']/div[@id='wrapperinner']/div[@id='area']/div[@id='areainner']/div[@id='contentarea']/div[2]/div[1]/form[1]/div[1]/label[2]/span[1]")
	WebElement radioNobtn;
	
	//Enter Email ID
	@FindBy(id="email")
	WebElement email;
	
	//Enter Password
	@FindBy(id="password")
	WebElement password;
	
	//Click on Submit Button
	@FindBy(id="submit_addon")
	WebElement submitbtn;
	
	//Click on Cancel Button
	@FindBy(id="cancel_addon")
	WebElement cancelbtn;
	
	public void clickonBuyoptionIndividualTicket() {
		bookticket.click();
	}
	
	public void clickonBuyoptionTableofTen() {
		tableof10.click();
	}
	
	public void clickOnYesradiobtn() {
		radioYesbtn.click();
	}
	
	public void clickOnNoradiobtn() {
		radioNobtn.click();
	}
	public void enteremail(String emailId) {
		email.sendKeys(emailId);
	}
	
	public void enterPassword(String userpassword) {
		password.sendKeys(userpassword);
	}
	
	public Registration_Page clickSubmit() {
		submitbtn.click();
		return new Registration_Page();
	}

	public void clickCancel() {
		cancelbtn.click();
	}
}
