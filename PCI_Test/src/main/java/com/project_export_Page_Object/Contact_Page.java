package com.project_export_Page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project_expoert_BaseClass.Base_Class;

public class Contact_Page extends Base_Class {
	
	WebDriverWait wait=new WebDriverWait(driver,10);

	public Contact_Page() {

		PageFactory.initElements(driver, this);
	}

	// Email
	@FindBy(id = "email")
	WebElement emailID;

	// Name
	@FindBy(id = "name")
	WebElement name1;

	// Subject
	@FindBy(id = "subject")
	WebElement subject;

	// Message
	@FindBy(id = "message")
	WebElement message;

	// Submit Button
	@FindBy(id = "submit_btn")
	WebElement submitbtn;

	// Enter user Email
	public void enteremailId(String useremail) {
		emailID.sendKeys(useremail);
	}

	// Enter User Name
	public void entername(String username) {
		name1.sendKeys(username);
	}

	// Enter Subject
	public void entersubject(String subjecttext) {
		subject.sendKeys(subjecttext);
	}
	
	// Enter Message
		public void entermessage(String messagetext) {
			subject.sendKeys(messagetext);
		}

	// Click on Submit Button
	public void clickonsubmitbtn() {
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("submit_btn"))));
		submitbtn.click();
	}
}
