package com.pixated.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@name='salutationtype']")
	private WebElement salutation;

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstname;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastname;
	@FindBy(xpath = "//input[@name='department']")
	private WebElement dptname;
	@FindBy(xpath = "//input[@name='mobile']")
	private WebElement mob;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;
	@FindBy(xpath = "//input[@name='account_name' ]/following-sibling::img")
	private WebElement addOrganizationbtn;

	@FindBy(xpath = "//input[@name='support_start_date']")
	private WebElement startDate;
	@FindBy(xpath = "//input[@name='support_end_date']")
	private WebElement endDate;
	@FindBy(xpath = "//input[@name='description']")
	private WebElement desc;
	@FindBy(xpath = "//input[@class='crmButton small save' ]")
	private WebElement savebtn;

	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchbox;
	@FindBy(xpath = "//input[@name='search']")
	private WebElement serchbtn;
	@FindBy(xpath = "//select[@name='search_field']")
	private WebElement searchField;
	@FindBy(xpath = "//a[text()='infosys']")
	private WebElement searchPdt;

	@FindBy(xpath = "//input[@name='title']")
	private WebElement title;

	@FindBy(xpath = "//input[@name='assistant']")
	private WebElement asstName;

	@FindBy(xpath = "//input[@name='assistantphone']")
	private WebElement asstMob;
	@FindBy(xpath = "//input[@name='birthday']")
	private WebElement dob;
	@FindBy(xpath = "(//img[@title='Select'])[2]")
	private WebElement addReports;

	@FindBy(xpath = "(//input[@name='cpy'])[2]")
	private WebElement cpyAdress;
	@FindBy(xpath = "//input[@name='mailingpobox']")
	private WebElement poBox;

	@FindBy(xpath = "//input[@name='mailingcity']")
	private WebElement city;
	@FindBy(xpath = "//input[@name='mailingstate']")
	private WebElement state;
	@FindBy(xpath = "//input[@name='mailingzip']")
	private WebElement pCode;
	@FindBy(xpath = "//input[@name='mailingcountry']")
	private WebElement country;
	@FindBy(xpath = "//textarea[@name='mailingstreet']")
	private WebElement street;

	public WebElement getSalutation() {
		return salutation;
	}

	public WebElement getAddOrganizationbtn() {
		return addOrganizationbtn;
	}

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getSerchbtn() {
		return serchbtn;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getDptname() {
		return dptname;
	}

	public WebElement getMob() {
		return mob;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public WebElement getDesc() {
		return desc;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchPdt() {
		return searchPdt;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getAsstName() {
		return asstName;
	}

	public WebElement getAsstMob() {
		return asstMob;
	}

	public WebElement getDob() {
		return dob;
	}

	public WebElement getAddReports() {
		return addReports;
	}

	public WebElement getCpyAdress() {
		return cpyAdress;
	}

	public WebElement getPoBox() {
		return poBox;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getpCode() {
		return pCode;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getStreet() {
		return street;
	}

	/**
	 * this business library is create to createContact using lastName
	 * 
	 * @param lName
	 */
	public void createContact(String lName) {
		getLastname().sendKeys(lName);
		getSavebtn().click();
	}

	/**
	 * this business library is create to createContact using
	 * lastName,startdate,endDate
	 * 
	 * @param lName
	 */
	public void createContactWithDate(String lName, String startDate, String endDate) {
		getLastname().sendKeys(lName);
		getStartDate().clear();
		getStartDate().sendKeys(startDate);
		getEndDate().clear();
		getEndDate().sendKeys(endDate);
		getSavebtn().click();
	}

}
