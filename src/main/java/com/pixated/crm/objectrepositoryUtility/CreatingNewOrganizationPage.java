package com.pixated.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgName;

	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phnum;

	@FindBy(xpath = "//input[@id='email1']")
	private WebElement emailId;
	@FindBy(xpath = "//input[@id='ownership']")
	private WebElement ownerShip;
	@FindBy(xpath = "(//input[@class='crmbutton small save'])[2]")
	private WebElement savebutton;
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industry;
	@FindBy(xpath = "//input[@name='website']")
	private WebElement website;

	@FindBy(xpath = "//input[@name='employees']")
	private WebElement employee;

	@FindBy(xpath = "//input[@name='annual_revenue']")
	private WebElement anl_Rev;
	@FindBy(xpath = "//textarea[@name='bill_street']")
	private WebElement street;
	@FindBy(xpath = "//input[@name='bill_pobox']")
	private WebElement poBox;
	@FindBy(xpath = "//input[@name='bill_city']")
	private WebElement City;

	@FindBy(xpath = "//input[@name='bill_state']")
	private WebElement state;

	@FindBy(xpath = "//input[@name='bill_code']")
	private WebElement pCode;

	@FindBy(xpath = "//input[@name='bill_country']")
	private WebElement country;
	@FindBy(xpath = "(//input[@name='cpy'])[2]")
	private WebElement cpyAdress;
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement description;
	@FindBy(xpath = "(//input[@value='  Save  '])[1]")
	private WebElement save;
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement membOf;
	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement accType;

	@FindBy(xpath = "//select[@name='rating']")
	private WebElement rating;

	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchBox;

	@FindBy(xpath = "//select[@name='search_field']")
	private WebElement searchField;
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBtn;
	@FindBy(xpath = "//tr[@class='lvtColData']")
	private WebElement slctMember;

	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getPhnum() {
		return phnum;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public WebElement getOwnerShip() {
		return ownerShip;
	}

	public WebElement getSavebutton() {
		return savebutton;

	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getWebsite() {
		return website;
	}

	public WebElement getEmployee() {
		return employee;
	}

	public WebElement getAnl_Rev() {
		return anl_Rev;
	}

	public WebElement getStreet() {
		return street;
	}

	public WebElement getPoBox() {
		return poBox;
	}

	public WebElement getCity() {
		return City;
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

	public WebElement getCpyAdress() {
		return cpyAdress;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getMembOf() {
		return membOf;
	}

	public WebElement getAccType() {
		return accType;
	}

	public WebElement getRating() {
		return rating;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSlctMember() {
		return slctMember;
	}
	/**
	 * This is busines library is used to createContact
	 * @param orgname
	 */
	public void createOrg(String orgname) {
	getOrgName().sendKeys(orgname);
	getSavebutton().click();
	
	}
	/**
	 * This is busines library is used to createContact with orgname and phnum
	 * @param orgname
	 */
	public void createOrg(String orgname,String phNum) {
	getOrgName().sendKeys(orgname);
	getPhnum().sendKeys(phNum);
	getSavebutton().click();
	}
}