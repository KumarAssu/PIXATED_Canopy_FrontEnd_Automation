package com.pixated.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pixated.crm.generic.webDriverUtility.WebDriverUtility;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']")
	private WebElement home;
	
	@FindBy(xpath = "//a[text()='Calendar']")
	private WebElement calendar;
	
	@FindBy(xpath = "//a[@href='index.php?module=Leads&action=index']")
	private WebElement leads;
	@FindBy(xpath = "//a[@href='index.php?module=Accounts&action=index']")
	private WebElement organisation;
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contacts;
	
	@FindBy(xpath = "//a[@href='index.php?module=Potentials&action=index']")
	private WebElement oppourtunity;
	
	@FindBy(xpath = "//a[@href='index.php?module=Products&action=index']")
	private WebElement products;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement admistator;
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signout;
	
	public WebElement getHome() {
		return home;
	}

	public WebElement getCalendar() {
		return calendar;
	}

	public WebElement getLeads() {
		return leads;
	}

	public WebElement getOrganisation() {
		return organisation;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getOppourtunity() {
		return oppourtunity;
	}

	public WebElement getProducts() {
		return products;
	}

	public WebElement getAdmistator() {
		return admistator;
	}

	public WebElement getSignout() {
		return signout;
}
	
	public void logoutOperation() {
		WebDriverUtility wtil=new WebDriverUtility();
		wtil.mouseOverOnElement(driver, admistator);
		//movingTowardsElement(driver, admistator);
		getSignout().click();
	}
	/*
	 * public void clickOnCampaign() { wtil.
	 * 
	 * }
	 */
}