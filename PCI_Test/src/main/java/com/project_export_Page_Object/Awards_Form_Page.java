package com.project_export_Page_Object;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project_expoert_BaseClass.Base_Class;

public class Awards_Form_Page extends Base_Class {
	
	WebDriverWait wait=new WebDriverWait(driver,30);

	public Awards_Form_Page() {
		PageFactory.initElements(driver, this);
	}

	// FirstName
	@FindBy(id = "first_name")
	WebElement firstname;

	// LastNmae
	@FindBy(id = "last_name")
	WebElement lastname;

	// Job Tittle
	@FindBy(id = "job_title")
	WebElement jobtittle;

	// Company Name
	@FindBy(id = "company_name")
	WebElement companyname;

	// Postal Address1
	@FindBy(id = "postal_address1")
	WebElement postaladdress1;

	// Postal Address2
	@FindBy(id = "postal_address2")
	WebElement postaladdress2;

	// City
	@FindBy(id = "city")
	WebElement city;

	// PostCode
	@FindBy(id = "postcode")
	WebElement postcode;

	// Country
	@FindBy(id = "country")
	WebElement country;

	// Telephone No.
	@FindBy(id = "telephone_number")
	WebElement telephonenumber;

	// Preferred Email
	@FindBy(id = "preferred_email")
	WebElement preferredemail;

	// Company Twitter Username
	@FindBy(id = "company_twitter_username")
	WebElement companytwitterusername;

	// Project name
	@FindBy(id = "project-name-project-major-phase-end-date-must-be-no-more-than-12-months-prior-to-submission-deadline-date")
	WebElement projectname;

	// Project End Date
	@FindBy(id = "project-phase-end-date")
	WebElement projectenddate;
	
	//Select Date
	@FindBy(xpath="//a[contains(text(),'18')]")
	WebElement date;

	// Terma and Condition
	@FindBy(id = "params_terms")
	WebElement termscond;

	// Submit Button
	@FindBy(id = "btnsubmit")
	WebElement submitbtn;

	// Save Button
	@FindBy(id = "btnsave")
	WebElement savebtn;

	// Enter First Name
	public void enterFirstName(String firstName) {
		firstname.sendKeys(firstName);
	}

	// Enter Last Name
	public void enterLastName(String lastName) {
		lastname.sendKeys(lastName);
	}

	// Enter Job Tittle
	public void enterJobtittle(String jobTittle) {
		jobtittle.sendKeys(jobTittle);
	}

	// Enter Company Name
	public void enterCompanyName(String companyName) {
		companyname.sendKeys(companyName);
	}

	// Enter Pastal Address 1
	public void enterpostalAddress1(String post1) {
		postaladdress1.sendKeys(post1);
	}

	// Enter Pastal Address 2
	public void enterpostalAddress2(String post2) {
		postaladdress2.sendKeys(post2);
	}

	// Enter City
	public void enterCity(String city1) {
		city.sendKeys(city1);
	}

	// Enter PostCode
	public void enterPostCode(String postCode) {
		postcode.sendKeys(postCode);
	}

	// Select Country
	public void selectCountry(int i) {
		Select dropdown = new Select(country);
		dropdown.selectByIndex(i);
	}

	// Enter Telephone Number
	public void entertelephoneNo(String num) {
		telephonenumber.sendKeys(num);
	}

	// Enter Email
	public void enteremail(String email) {
		preferredemail.sendKeys(email);
	}

	// Enter Company twitter username
	public void entercompanytwittername(String comtwitter) {
		companytwitterusername.sendKeys(comtwitter);
	}

	// Enter Project Name
	public void enterprojectName(String projectName) {
		projectname.sendKeys(projectName);
	}

	// Enter Project End Date
	public void clickonprojectendDate() {
		projectenddate.click();
		
	}
	
	public void selectProjectDate() {
		date.click();
	}

	// Click terms and condition
	public void acceptTermsandConditions() {
		wait.until(ExpectedConditions.elementToBeClickable(termscond));
		termscond.click();
	}

	// Click Submit Button
	public void clickSubmitbtn() {
		submitbtn.click();
	}

	// Click on Save Button
	public void clickonSavebtn() {
		savebtn.click();
	}
	
}
