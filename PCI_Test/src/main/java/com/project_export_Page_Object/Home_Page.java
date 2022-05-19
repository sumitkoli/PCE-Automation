package com.project_export_Page_Object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project_expoert_BaseClass.Base_Class;

public class Home_Page extends Base_Class {

	public Home_Page() {
		PageFactory.initElements(driver, this);
	}
	
	//Contact Tab
	@FindBy(xpath="//span[contains(text(),'Contact')]")
	WebElement  contactTab;
	
	//Register Tab
	@FindBy(xpath="//span[contains(text(),'Register')]")
	WebElement  registerTab;
	
	//Awards Tab
	@FindBy(xpath="//span[contains(text(),'Awards')]")
	WebElement  awardsTab;
	
	//Awards// Categories & Criteria
	@FindBy(xpath="//a[contains(text(),'Categories & Criteria')]")
	WebElement categorycriteria;
	
	//Click on Contact Tab
	public Contact_Page clickonContactTab() {
		contactTab.click();
		return new Contact_Page();
	}
	
	//Click on Register Tab
	public Ticket_Register_Page clickonregisterTab() {
		
		registerTab.click();
		return new Ticket_Register_Page();
	}
	
	//Move to Awards Tab
	public void movetoAwardsTab() {
		Actions actions = new Actions(driver);
		
		actions.moveToElement(awardsTab).perform();
		}
	
	//Click on Awards// Categories & Criteria
	public Awards_Form_Page clickonCategoriesCriteria(){
		Actions actions = new Actions(driver);

		actions.moveToElement(categorycriteria).perform();

		categorycriteria.click();
		return new Awards_Form_Page();
	}
	
}
