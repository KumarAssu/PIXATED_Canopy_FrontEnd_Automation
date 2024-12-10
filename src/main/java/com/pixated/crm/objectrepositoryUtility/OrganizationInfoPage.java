package com.pixated.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	public OrganizationInfoPage(WebDriver driver) {
		//this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerinfo;
	
	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement orgNameMessage;
	
	@FindBy(xpath  = "//td[@id='mouseArea_Industry']")
	private WebElement industryMessage;
	
	@FindBy(xpath  = "//span[@id='dtlview_Phone']")
	private WebElement mobNumMessage;

	public WebElement getHeaderinfo() {
		return headerinfo;
	}

	public WebElement getOrgNameMessage() {
		return orgNameMessage;
	}

	public WebElement getIndustryMessage() {
		return industryMessage;
	}

	public WebElement getMobNumMessage() {
		return mobNumMessage;
	}
	
   

}
