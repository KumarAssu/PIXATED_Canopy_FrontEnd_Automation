package com.pixated.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsWindow {
	
	public OrganizationsWindow(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}

	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchBox ;
	
	@FindBy(xpath = "//input[@name='search']")
     private WebElement searchBtn;

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
}
