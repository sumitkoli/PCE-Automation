package com.project_export_Page_Object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project_expoert_BaseClass.Base_Class;

public class Categories_and_Criteria_Page extends Base_Class {

	public Categories_and_Criteria_Page() {

		PageFactory.initElements(driver, this);
	}

	//New Application
	@FindBy(xpath = "//a[contains(text(),'New Application')]")
	WebElement newApp;

	//Saved Application 
	@FindBy(xpath = "//input[@value='Saved Application']")
	WebElement savedApp;

	//Click on New Application
	public Awards_Form_Page clickonNewappBtn() {
		newApp.click();
		return new Awards_Form_Page();
	}

	//Click on Saved Application
	public void clickonSavedappBtn() {
		savedApp.click();
	}
}
