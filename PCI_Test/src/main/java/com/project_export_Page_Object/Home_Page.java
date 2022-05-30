package com.project_export_Page_Object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project_expoert_BaseClass.Base_Class;

public class Home_Page extends Base_Class {

	Actions actions = new Actions(driver);
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
	
	//Expo Tab
	@FindBy(xpath="//span[contains(text(),'Expo')]")
	WebElement expoTab;
	
	//SME Zone
	@FindBy(xpath="//a[contains(text(),'SME Zone')]")
	WebElement  sme_zone;
	
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
		
		
		actions.moveToElement(awardsTab).perform();
		}
	
	//Click on Awards// Categories & Criteria
	public Awards_Form_Page clickonCategoriesCriteria(){

		actions.moveToElement(categorycriteria).perform();

		categorycriteria.click();
		return new Awards_Form_Page();
	}
	
	//Move To Expo Tab
	public void move_To_Expo_Tab() {
		actions.moveToElement(expoTab).perform();
	}
	
	public SME_Zone_Page click_On_SME_Zone() {
		
		actions.moveToElement(sme_zone).perform();
		sme_zone.click();
		return new SME_Zone_Page();
	}
	
	
}
