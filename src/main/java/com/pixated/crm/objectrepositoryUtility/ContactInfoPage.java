package com.pixated.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
   
	public ContactInfoPage(WebDriver driver) {
		//this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath = "//td[@id='mouseArea_Last Name']")
	private WebElement lastNameMessage;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMessage;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgMessage;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement startDateMessage;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement endDateMessage;

	public WebElement getLastNameMessage() {
		return lastNameMessage;
	}

	public WebElement getHeaderMessage() {
		return headerMessage;
	}

	public WebElement getOrgMessage() {
		return orgMessage;
	}

	public WebElement getStartDateMessage() {
		return startDateMessage;
	}

	public WebElement getEndDateMessage() {
		return endDateMessage;
	}
	
	
}
