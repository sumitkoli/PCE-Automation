package com.project_export_Page_Object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project_expoert_BaseClass.Base_Class;

public class Registration_Page extends Base_Class{

	public Registration_Page() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Select title
	@FindBy(id="title")
	WebElement tittle;
	
	//Enter First Name
	@FindBy(id="first_name")
	WebElement firstName;
	
	//Enter  Last Name
	@FindBy(id="last_name")
	WebElement laatName;
	
	//Enter Password
	@FindBy(id="password")
	WebElement password;
	
	//Confirm Password
	@FindBy(id="confirm_password")
	WebElement confirmpassword;
	
	//Enter Job Tittle
	@FindBy(id="job_title")
	WebElement jobTittle;
	
	//Select Company
	@FindBy(id="company")
	WebElement company;
	
	//Enter Address
	@FindBy(id="address")
	WebElement address;
	
	//Enter Country
	@FindBy(id="country")
	WebElement country;
	
	//Enter Email Address
	@FindBy(id="email")
	WebElement email;
	
	//Enter Phone no.
	@FindBy(id="phone")
	WebElement phone;
	
	//Select Industry
	@FindBy(id="industry")
	WebElement industry;
	
	//Select Experience Level
	@FindBy(id="experience_level")
	WebElement experience_level;
	
	//share your details : Click on Yes Button
	@FindBy(xpath="//body[1]/div[8]/div[1]/div[2]/div[1]/div[2]/form[1]/table[1]/tbody[1]/tr[15]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/input[1]")
	WebElement selectYes;
	
	///share your details : Click on No Button
	@FindBy(xpath="//body[1]/div[8]/div[1]/div[2]/div[1]/div[2]/form[1]/table[1]/tbody[1]/tr[15]/td[2]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")
	WebElement selectNo;
	
	//Select the Reaistration Category
	@FindBy(id="registration_category")
	WebElement regCategory;
	
	//Select dietary requirements 1
	@FindBy(id="dietary_requirements")
	WebElement dietary_requirements1;
	
	//Select Stadium Tour
	@FindBy(xpath="//select[@name='do-you-wish-to-join-stadium-tour']")
	WebElement stadiumTour;
	
	//Select Join Tour
	@FindBy(xpath="//select[@name='do-you-wish-to-join-tour']")
	WebElement joinTour;
	
	//Select dietary requirements 2
	@FindBy(id="do-you-have-any-dietary-requirements")
	WebElement dietary_requirements2;
	
	//Enter Professional Body membership
	@FindBy(id="professional-body-membership-if-applicable")
	WebElement profmembership;
	
	//Upload Files
	@FindBy(id="files_1")
	WebElement uploadfiles;
	
	//Enter Coupenn Code
	@FindBy(id="coupon_code")
	WebElement couponcode;
	
	//Click on Subscription
	@FindBy(xpath="//input[@name='subscription']")
	WebElement subscription;
	
	//Click on terms_and_conditions
	@FindBy(id="terms_and_conditions")
	WebElement termsconditions;
	
	//Click on Submit Button
	@FindBy(id="submit_btn")
	WebElement submit;
	
	public void clickOnSubscription() {
		subscription.click();
	}
	
	public void clickOntermsandCondt() {
		termsconditions.click();
	}
	
	public Purchase_Page clickOnSubmitbtn() {
		submit.click();
		return new Purchase_Page();
	}
}
