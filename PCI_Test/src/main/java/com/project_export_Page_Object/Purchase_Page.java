package com.project_export_Page_Object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project_expoert_BaseClass.Base_Class;

public class Purchase_Page extends Base_Class {

	public Purchase_Page() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='btnSubmit']")
	WebElement submitBtn;

	// Back Button
	@FindBy(id = "previous_page")
	WebElement backBtn;

	public void clickonSubmitbtn() {
		submitBtn.click();
	}

	public Registration_Page clickonBackbtn() {
		backBtn.click();
		return new Registration_Page();
	}
}
