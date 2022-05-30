package com.project_export_Page_Object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.project_expoert_BaseClass.Base_Class;

public class SME_Zone_Page extends Base_Class{

	public SME_Zone_Page() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="email-id")
	WebElement email_id;
	
	@FindBy(id="contact-no")
	WebElement contact_no;
	
	@FindBy(id="message")
	WebElement message;
	
	@FindBy(id="speaker")
	WebElement speaker;
	
	@FindBy(id="submit_btn")
	WebElement submit_btn;
	
	@FindBy(id="sme")
	WebElement sme;
	
	public void enter_Name(String Name) {
		name.sendKeys(Name);
	}
	
	public void enter_EmailId(String email) {
		email_id.sendKeys(email);
	}
	
	public void enter_Contactno(String number) {
		contact_no.sendKeys(number);
	}
	
	public void enter_Message(String Mesg) {
		message.sendKeys(Mesg);
	}
	
	public void select_Speaker(String value) {
		Select dropdown=new Select(speaker);
		dropdown.selectByValue(value);
		System.out.println(dropdown.getFirstSelectedOption().getText());
	}
	
	public void select_SME(String value1) {
		Select dropdown=new Select(sme);
		dropdown.selectByValue(value1);
		System.out.println(dropdown.getFirstSelectedOption().getText());
	}
	
	
	public void click_SubmitBtn() {
		submit_btn.click();
	}
}
